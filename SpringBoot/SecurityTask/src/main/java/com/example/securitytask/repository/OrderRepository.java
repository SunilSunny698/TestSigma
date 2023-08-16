package com.example.securitytask.repository;

import com.example.securitytask.model.Orders;
import com.example.securitytask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>, JpaSpecificationExecutor<Orders> {
    List<Orders> findByCustomer(User customer);
}
