package com.example.securitytask.service;


import com.example.securitytask.Dto.RequestDto;
import com.example.securitytask.model.Orders;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.OrderRepository;
import com.example.securitytask.repository.UserRepository;
import com.example.securitytask.specification.FilterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private UserRepository custRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private FilterSpecification<User> filterCustomer;

    @Autowired
    private FilterSpecification<Orders> filterOrders;

    public void addCustomer(User c){
        custRepo.save(c);
    }
    public void addOrders(Orders o){
        orderRepo.save(o);
    }
    public List<Orders> testQuery(User customer){
        return orderRepo.findByCustomer(customer);
    }
    public User getCustomer(int id){
        return custRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<User> applyFilterCust(RequestDto req){
        Specification<User> spec = filterCustomer.<User,Orders>applySpecification(req.getCriteriaDtoList(), req.getBoolOp());
        return custRepo.findAll(spec);
    }
    public List<Orders> applyFilterOrder(RequestDto req){
        Specification<Orders> spec = filterOrders.<Orders,User>applySpecification(req.getCriteriaDtoList(),req.getBoolOp());
        return orderRepo.findAll(spec);
    }

    public Integer getUserIdByUsername(String username){
        User user = custRepo.findByUsername(username);
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }

}
