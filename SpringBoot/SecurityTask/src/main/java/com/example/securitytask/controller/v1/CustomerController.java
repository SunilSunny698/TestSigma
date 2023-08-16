package com.example.securitytask.controller.v1;


import com.example.securitytask.Dto.RequestDto;
import com.example.securitytask.model.User;
import com.example.securitytask.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/specc")
public class CustomerController {
    @Autowired
    private DeliveryService deliveryService;
    @PostMapping
    public List<User> index2(@RequestBody RequestDto requestDto){
        return deliveryService.applyFilterCust(requestDto);
    }
}
