package com.example.securitytask.controller;

import com.example.securitytask.Dto.LoginDto;
import com.example.securitytask.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MyUserService userService;

    @GetMapping
    public String load(){
        return "login";
    }

    @PostMapping
    public String process(LoginDto loginDto){
        userService.loadUserByUsername(loginDto.getUsername());
        return "login";
    }

}
