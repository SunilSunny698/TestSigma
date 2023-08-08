package com.intro.mvc.specifications;

import com.intro.mvc.model.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {
    public static Specification<Student> hasName(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),name));
    }
    public static Specification<Student> hasGender(String gender){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("gender"),gender));
    }
    public static Specification<Student> hasGreaterThan(int age){
        return ((root,query,criteriaBuilder)->criteriaBuilder.greaterThan(root.get("age"),age));
    }
    public static Specification<Student> hasLesserThan(int age){
        return ((root,query,criteriaBuilder)->criteriaBuilder.lessThan(root.get("age"),age));
    }
}
