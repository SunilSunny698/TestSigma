package com.intro.delivery.controller;

import com.intro.delivery.dto.CriteriaDto;
import com.intro.delivery.dto.RequestDto;
import com.intro.delivery.model.Customer;
import com.intro.delivery.model.Orders;
import com.intro.delivery.repository.CustomerRepository;
import com.intro.delivery.service.DeliveryService;
import com.intro.delivery.service.FilterSpecification;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private DeliveryService deliveryService;



    @PostMapping("insert/c")
    public String index(@RequestBody Customer c){
        System.out.println("Post c");
        System.out.println(c);
        deliveryService.addCustomer(c);
        return "Inserted";
    }
    @PostMapping("insert/o")
    public String index(@RequestBody Orders o){
        System.out.println("Post o");
        System.out.println(o);
        deliveryService.addOrders(o);
        return "Inserted";

    }
//    @GetMapping("spec/{id}")
//    public List<Orders> index(@PathVariable int id){
//        List<Orders> resp = new ArrayList<>();
//        try{
//            resp = deliveryService.testQuery(deliveryService.getCustomer(id));
//
//        }catch (Exception e){
//            System.out.println(e.getCause());
//        };
//        return resp;
//    }

    @PostMapping("spec1")
    public List<Customer> index1(@RequestBody CriteriaDto criteriaDto){
        List<CriteriaDto> cri = new ArrayList<>();
        cri.add(criteriaDto);
        RequestDto req = new RequestDto();
        req.setCriteriaDtoList(cri);
        req.setBoolOp(RequestDto.BooleanOperator.AND);
        return deliveryService.applyFilterCust(req);
    }

    @PostMapping("specc")
    public List<Customer> index2(@RequestBody RequestDto requestDto){
        return deliveryService.applyFilterCust(requestDto);
    }

    @PostMapping("speco")
    public List<Orders> index3(@RequestBody RequestDto requestDto){
        System.out.println(requestDto);
        return deliveryService.applyFilterOrder(requestDto);
    }


}
