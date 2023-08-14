package com.example.securitytask.controller;

import com.example.securitytask.jwt.JwtUtil;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import com.example.securitytask.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class V1controller {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/v1")
    public String load(@CookieValue(name = "vjwt", defaultValue = "null")String cookie, Authentication authentication){
        User u = userRepository.findByUsername(authentication.getName());

        if(cookie.equals("null")){
            userService.modifyApiVal(u.getUsername(),false);
        }
        if(u!=null) {
            if (u.isApi() && !cookie.equals("null")) {
                return "v1";
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/token/v1/generate")
    public String loadA(Model model, Authentication authentication, HttpServletResponse response){
        userService.modifyApiVal(authentication.getName(),true);
        String token = authentication.getName()+" v1";
        String jwt = jwtUtil.generateToken(token);
        Cookie cookie = new Cookie("vjwt",jwt);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/home?success=true";
    }
}
