package com.example.securitymysql.controller;


import com.example.securitymysql.dto.LoginDto;
import com.example.securitymysql.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
public class SigninController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @GetMapping
    public String loadSigin(){
        return "signin";
    }
    @PostMapping
    public String signin(@ModelAttribute(name = "user")LoginDto loginDto){

        return "home";
    }

}
