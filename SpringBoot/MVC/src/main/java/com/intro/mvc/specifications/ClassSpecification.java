package com.intro.mvc.specifications;

import com.intro.mvc.dto.CriteriaDto;
import com.intro.mvc.dto.RequestDto;
import com.intro.mvc.model.Class;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClassSpecification {

    public static Specification<Class> applySpecification(CriteriaDto cDto){
        System.out.println("spec call");
        return new Specification<Class>() {
            @Override
            public Predicate toPredicate(Root<Class> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(cDto.getColumn()),cDto.getValue());
            }
        };
    }
    public static Specification<Class> applySpecification(List<CriteriaDto> listOfReqs, RequestDto.BooleanOperator boolOp){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> Predicates = new ArrayList<>();
            for (CriteriaDto cDto:listOfReqs) {
                switch (cDto.getOperation()) {
                    case EQUAL -> {
                        Predicate equal = criteriaBuilder.equal(root.get(cDto.getColumn()), cDto.getValue());
                        Predicates.add(equal);
                    }
                    case LESS_THAN -> {
                        Predicate less = criteriaBuilder.lessThan(root.get(cDto.getColumn()), cDto.getValue());
                        Predicates.add(less);
                    }
                    case GREATER_THAN -> {
                        Predicate greater = criteriaBuilder.greaterThan(root.get(cDto.getColumn()), cDto.getValue());
                        Predicates.add(greater);
                    }
                    default -> throw new IllegalStateException("Unexpected value:");
                }
            }
            if(boolOp.equals(RequestDto.BooleanOperator.AND)){
                return criteriaBuilder.and(Predicates.toArray(new Predicate[0]));
            }
            else{
                return criteriaBuilder.or(Predicates.toArray(new Predicate[0]));
            }
        };
    }
}
