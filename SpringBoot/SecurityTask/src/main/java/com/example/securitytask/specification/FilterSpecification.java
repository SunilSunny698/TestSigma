package com.example.securitytask.specification;


import com.example.securitytask.Dto.CriteriaDto;
import com.example.securitytask.Dto.RequestDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.*;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

@Service
public class FilterSpecification<T> {

    public Specification<T> applySpecification(CriteriaDto criteriaDto){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(criteriaDto.getColumn()),criteriaDto.getValue());
            }
        };
    }
    public <R,J> Specification<T> applySpecification(List<CriteriaDto> criteriaDtoList, RequestDto.BooleanOperator booleanOperator){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            for (CriteriaDto cDto: criteriaDtoList) {

                Expression<String> main;
                if(cDto.getColumn().contains("from")){
                    main = root.join(cDto.getColumn().split(" ")[2]).get(cDto.getColumn().split(" ")[0]);

                }
                else{
                    main = root.get(cDto.getColumn());
                }

                switch (cDto.getOperation()){

                    case EQUAL:
                        Object value = getTypedValue(main,cDto.getValue());
                        Predicate equal = criteriaBuilder.equal(main,value);
                        predicates.add(equal);
                        break;

                    case LESS_THAN:
                        Predicate less = criteriaBuilder.lessThan(main,cDto.getValue());
                        predicates.add(less);
                        break;

                    case GREATER_THAN:
                        Predicate greater = criteriaBuilder.greaterThan(main,cDto.getValue());
                        predicates.add(greater);
                        break;

                    case BETWEEN:
                        String[] s = cDto.getValue().split(",");
                        Predicate between = criteriaBuilder.between(main,s[0],s[1]);
                        predicates.add(between);
                        break;

                    case LIKE:
                        Predicate like = criteriaBuilder.like(main,"%"+cDto.getValue()+"%");
                        predicates.add(like);
                        break;

                    case STARTS_WITH:
                        Predicate start = criteriaBuilder.like(main,cDto.getValue()+"%");
                        predicates.add(start);
                        break;
                    case ENDS_WITH:
                        Predicate end = criteriaBuilder.like(main,"%"+cDto.getValue());
                        predicates.add(end);
                        break;
                    case IN:
                        String[] l = cDto.getValue().split(",");
                        List<Object> o = new ArrayList<>();
                        for (String i:l) {
                            o.add(getTypedValue(main,i));
                        }
                        Predicate in = main.in(o);
                        predicates.add(in);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value:");
                }
            }
            if(booleanOperator.equals(RequestDto.BooleanOperator.AND)){
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
            else{
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }

    private Object getTypedValue(Expression<String> main, String s) {
        Class<?> columnType = getColumnType(main);
        Object val;
        if (columnType == Boolean.class || columnType == boolean.class){
            val = Boolean.parseBoolean(s);
        } else if (columnType!=null && columnType.isEnum()) {
            val = Enum.valueOf((Class<Enum>) columnType, s);
        }else{
            val = s;
        }
        return val;
    }
    public Class<?> getColumnType(Expression<String> expression) {
        if (expression instanceof Path<?>) {
            Path<?> path = (Path<?>) expression;
            return path.getModel().getBindableJavaType();
        } else {
            throw new IllegalArgumentException("Expression is not a Path.");
        }
    }

}


