package com.intro.mvc.repositories;

import com.intro.mvc.model.Class;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Integer> , JpaSpecificationExecutor<Class> {

    @Query("SELECT c FROM Class c WHERE c.capacity = :capacity")
    List<Class> findClassesByCapacity(int capacity);

}
