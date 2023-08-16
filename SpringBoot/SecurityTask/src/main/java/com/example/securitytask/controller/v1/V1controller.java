package com.example.securitytask.controller.v1;

import com.example.securitytask.jwt.JwtUtil;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import com.example.securitytask.service.DeliveryService;
import com.example.securitytask.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
public class V1controller {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserService userService;

    @GetMapping("/v1")
    public String load(){
        return "v1";
    }

    @GetMapping("/token/v1/generate")
    public String loadA(Authentication authentication){
        User newU = new User();
        String token = authentication.getName()+"$"+ LocalDateTime.now();
        String jwt = jwtUtil.generateToken(token);
//        Cookie cookie = new Cookie("vjwt",jwt);
//        cookie.setPath("/");
//        response.addCookie(cookie);
        newU.setJwt(jwt);
        newU.setUsername(token);
        newU.setApi(true);
        userService.save(newU);

        return "redirect:/home?success=true";
    }
}
