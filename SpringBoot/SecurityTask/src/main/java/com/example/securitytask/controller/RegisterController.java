package com.example.securitytask.controller;

import com.example.securitytask.Dto.RegisterDto;
import com.example.securitytask.mapper.UserMapper;

import com.example.securitytask.model.User;
import com.example.securitytask.service.MyUserService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyUserService userService;
    @GetMapping
    public String load(){
        return "register";
    }

    @ModelAttribute("user")
    public RegisterDto userRegisterDto(){
        return new RegisterDto();
    }

    @PostMapping
    public String process(RegisterDto registerDto){
        User u = userMapper.toUser(registerDto);
//        User u = new User();
//        u.setUsername(registerDto.getUsername());
//        u.setPassword(registerDto.getPassword());
//        u.setEmail(registerDto.getEmail());
        userService.save(u);
        return "redirect:/login";
    }
}
