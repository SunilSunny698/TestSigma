package com.intro.delivery.service;

import com.intro.delivery.dto.CriteriaDto;
import com.intro.delivery.dto.RequestDto;
import com.intro.delivery.model.Customer;
import com.intro.delivery.model.Orders;
import com.intro.delivery.repository.CustomerRepository;
import com.intro.delivery.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
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
    private CustomerRepository custRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private FilterSpecification<Customer> filterCustomer;

    @Autowired
    private FilterSpecification<Orders> filterOrders;

    public void addCustomer(Customer c){
        custRepo.save(c);
    }
    public void addOrders(Orders o){
        orderRepo.save(o);
    }
    public List<Orders> testQuery(Customer customer){
        return orderRepo.findByCustomer(customer);
    }
    public Customer getCustomer(int id){
        return custRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Customer> applyFilterCust(RequestDto req){
        Specification<Customer> spec = filterCustomer.<Customer,Orders>applySpecification(req.getCriteriaDtoList(), req.getBoolOp());
        return custRepo.findAll(spec);
    }
    public List<Orders> applyFilterOrder(RequestDto req){
        Specification<Orders> spec = filterOrders.<Orders,Customer>applySpecification(req.getCriteriaDtoList(),req.getBoolOp());
        return orderRepo.findAll(spec);
    }

}
