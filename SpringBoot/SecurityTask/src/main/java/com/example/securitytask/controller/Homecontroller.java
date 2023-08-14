package com.example.securitytask.controller;

import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Homecontroller {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String load(@CookieValue(name = "bjwt",defaultValue = "null")String cookie, Authentication authentication){
        User u = userRepository.findByUsername(authentication.getName());
        if(u!=null){
            if(u.isApi() && cookie.equals("null")){
                return "redirect:/login";
            }
        }


        return "home";
    }
}
