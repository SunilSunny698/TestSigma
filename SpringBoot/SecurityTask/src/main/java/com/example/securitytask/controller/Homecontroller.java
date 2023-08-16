package com.example.securitytask.controller;

import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class Homecontroller {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String load(Model model,Authentication authentication){
        User u = userRepository.findByUsername(authentication.getName());
        List<User> tokens = userRepository.findByUsernameStartingWithAndApi(authentication.getName()+"$",true);
        System.out.println(tokens);
        model.addAttribute("tokens",tokens);
        model.addAttribute("name",u.getUsername());
        return "home";

    }
}
