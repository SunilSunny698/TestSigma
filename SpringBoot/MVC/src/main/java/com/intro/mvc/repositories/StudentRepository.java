package com.intro.mvc.repositories;

import com.intro.mvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    List<Student> findByGender(String gender);
}
