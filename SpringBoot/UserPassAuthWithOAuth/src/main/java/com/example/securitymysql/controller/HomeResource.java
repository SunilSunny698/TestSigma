package com.example.securitymysql.controller;

import com.example.securitymysql.dto.LoginDto;
import com.example.securitymysql.dto.NewUserDto;
import com.example.securitymysql.jwt.JwtUtil;
import com.example.securitymysql.models.AuthenticationRequest;
import com.example.securitymysql.service.MyUserDetailsService;
import com.example.securitymysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeResource {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;



    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/home")
    public String home(){
        return "home";
    }




    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome User";
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
//            );
//        }catch (BadCredentialsException e){
//            throw new Exception("Not a valid user");
//        }
//        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(jwt);
//    }
}
