package com.example.securitytask.controller.v1;

import com.example.securitytask.Dto.RequestDto;
import com.example.securitytask.model.Orders;
import com.example.securitytask.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class OrderController {
    @Autowired
    private DeliveryService deliveryService;
    @GetMapping("/v1/hi")
    public String wave(){
        System.out.println("hii");
        return "hi";
    }
    @PostMapping("/v1/speco")
    public List<Orders> index3(@RequestBody RequestDto requestDto){
        System.out.println(requestDto);
        return deliveryService.applyFilterOrder(requestDto);
    }
    @PostMapping("/v1/inserto")
    public String index(@RequestBody Orders o){
        System.out.println("Post o");
        System.out.println(o);
        deliveryService.addOrders(o);
        return "Inserted";

    }
}
