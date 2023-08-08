package com.intro.delivery.repository;

import com.intro.delivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> , JpaSpecificationExecutor<Customer> {
//    @Query(value = "Select * from customer c JOIN orders o ON c.id = o.customer_id",nativeQuery = true)
//    List<Customer> joinQuery();
}
