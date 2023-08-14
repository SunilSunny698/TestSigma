package com.example.securitymysql.controller;

import com.example.securitymysql.dto.NewUserDto;
import com.example.securitymysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String loadSignup(){
        return "signup";
    }
    @PostMapping
    public String signup(@ModelAttribute(name = "user")NewUserDto newUserDto){
        userService.save(newUserDto);
        return "redirect:/signin";
    }
}
