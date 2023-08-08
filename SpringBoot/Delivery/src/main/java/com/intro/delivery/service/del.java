//package com.intro.delivery.service;
//
//import com.intro.delivery.dto.CriteriaDto;
//import com.intro.delivery.dto.RequestDto;
//import jakarta.persistence.criteria.*;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.lang.reflect.*;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class FilterSpecification<T> {
//
//    public Specification<T> applySpecification(CriteriaDto criteriaDto){
//        return new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get(criteriaDto.getColumn()),criteriaDto.getValue());
//            }
//        };
//    }
//    public <R,J> Specification<T> applySpecification(List<CriteriaDto> criteriaDtoList, RequestDto.BooleanOperator booleanOperator){
//        return (root, query, criteriaBuilder) -> {
//
//            Join<R,J> join = null;
//            List<Predicate> predicates = new ArrayList<>();
//            for (CriteriaDto cDto: criteriaDtoList) {
////                Expression<String> main;
//
//                switch (cDto.getOperation()){
//
//                    case EQUAL -> {
//                        Predicate equal=null;
//                        if(getColumnType(root,cDto.getColumn())!=null){
//                            Object value = getTypedValue(root, cDto.getColumn(), cDto);
//                            equal = criteriaBuilder.equal(root.get(cDto.getColumn()),value);
//                        }
//                        else if(join!=null) {
//                            Object value = getTypedValue(root, cDto.getColumn(), cDto);
//                            equal = criteriaBuilder.equal(join.get(cDto.getColumn()),value);
//                        }
//
//                        predicates.add(equal);
//                    }
//                    case LESS_THAN -> {
//                        Predicate less = null;
//                        if(getColumnType(root,cDto.getColumn())!=null){
//                            less = criteriaBuilder.lessThan(root.get(cDto.getColumn()), cDto.getValue());
//
//                        } else if (join!=null) {
//                            less = criteriaBuilder.lessThan(join.get(cDto.getColumn()), cDto.getValue());
//                        }
//
//                        predicates.add(less);
//                    }
//                    case GREATER_THAN -> {
//                        Predicate greater = null;
//                        if(getColumnType(root,cDto.getColumn())!=null){
//                            greater = criteriaBuilder.greaterThan(root.get(cDto.getColumn()), cDto.getValue());
//                        } else if (join!=null) {
//                            greater = criteriaBuilder.greaterThan(join.get(cDto.getColumn()), cDto.getValue());
//                        }
//
//                        predicates.add(greater);
//                    }
//                    case BETWEEN -> {
//                        String[] s = cDto.getValue().split(",");
//                        Predicate between = null;
//                        if(getColumnType(root,cDto.getColumn())!=null){
//                            between = criteriaBuilder.between(root.get(cDto.getColumn()),Long.parseLong(s[0]),Long.parseLong(s[1]));
//
//                        } else if (join!=null) {
//                            between =  criteriaBuilder.between(join.get(cDto.getColumn()),Long.parseLong(s[0]),Long.parseLong(s[1]));
//                        }
//
//                        predicates.add(between);
//                    }
//                    case LIKE -> {
//                        Predicate like = null;
//                        if(getColumnType(root,cDto.getColumn())!=null){
//                            like = criteriaBuilder.like(root.get(cDto.getColumn()),"%"+cDto.getValue()+"%");
//
//                        } else if (join!=null) {
//                            like = criteriaBuilder.like(join.get(cDto.getColumn()),"%"+cDto.getValue()+"%");
//                        }
//
//                        predicates.add(like);
//                    }
//                    case INNER_JOIN -> {
//                        join= root.join(cDto.getJoinTable(),JoinType.INNER);
//                    }
//                    case LEFT_JOIN -> {
//                        join= root.join(cDto.getJoinTable(),JoinType.LEFT);
//                    }
//                    case RIGHT_JOIN -> {
//                        join= root.join(cDto.getJoinTable(),JoinType.RIGHT);
//                    }
//
//                    default -> throw new IllegalStateException("Unexpected value:");
//                }
//            }
//            if(booleanOperator.equals(RequestDto.BooleanOperator.AND)){
//                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//            }
//            else{
//                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
//            }
//        };
//    }
//
//    private Object getTypedValue(Path<?> path, String columnName, CriteriaDto c) {
//        Class<?> columnType = getColumnType(path,columnName);
//        Object val;
//        if (columnType == Boolean.class || columnType == boolean.class){
//            val = Boolean.parseBoolean(c.getValue());
//        } else if (columnType!=null && columnType.isEnum()) {
//            val = Enum.valueOf((Class<Enum>) columnType, c.getValue());
//        }else{
//            val = c.getValue();
//        }
//        return val;
//    }
//    private Class<?> getColumnType(Path<?> path, String columnName) {
//        if (path instanceof Root<?>) {
//            Root<?> root = (Root<?>) path;
//            try {
//                Field field = root.getModel().getBindableJavaType().getDeclaredField(columnName);
//                return field.getType();
//            } catch (NoSuchFieldException e) {
//
//                return null;
//            }
//        } else if (path instanceof Join<?, ?>) {
//
//            Join<?, ?> join = (Join<?, ?>) path;
//            try {
//                Field field = join.getModel().getBindableJavaType().getDeclaredField(columnName);
//                return field.getType();
//            } catch (NoSuchFieldException e) {
//
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
//
//}
//
//


//private void formatRequest(RequestDto req){
//        CriteriaDto newC = null;
//        for (CriteriaDto c:req.getCriteriaDtoList()) {
//        if(c.getOperation() == CriteriaDto.Operation.CUST_ORDERS){
//        if(c.getColumn() != null && c.getValue() != null){
//        newC =new CriteriaDto();
//        newC.setColumn(c.getColumn());
//        newC.setValue(c.getValue());
//        newC.setOperation(CriteriaDto.Operation.EQUAL);
//        }
//        c.setJoinTable("customer");
//        c.setOperation(CriteriaDto.Operation.INNER_JOIN);
//        break;
//        }
//        }
//        if(newC!=null){
//        System.out.println("Check");
//        List<CriteriaDto> newL = req.getCriteriaDtoList();
//        newL.add(newC);
//        req.setCriteriaDtoList(newL);
//        }
//
//        }