package com.intro.delivery.repository;

import com.intro.delivery.model.Customer;
import com.intro.delivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>, JpaSpecificationExecutor<Orders> {
    List<Orders> findByCustomer(Customer customer);
}
