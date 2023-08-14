package com.example.securitytask.filter;

import com.example.securitytask.jwt.JwtUtil;
import com.example.securitytask.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component

public class V1Filter extends OncePerRequestFilter {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt;
        String username = null;
        String token;
        if(request.getRequestURI().equalsIgnoreCase("/v1") && extractCookieValue(request,"vjwt")!=null){
            System.out.println(request.getRequestURI());
            jwt = extractCookieValue(request,"vjwt");
            token = jwtUtil.extractUsername(jwt);
            System.out.println(token);
            if(token.contains("v1")){
                String[] s = token.split(" ");
                username = s[0];
                System.out.println(username);
            }
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                UserDetails userDetails = this.myUserService.loadUserByUsername(username);

                if(jwtUtil.validateToken(jwt,token)){

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }

            }
        }
        else if(request.getRequestURI().equalsIgnoreCase("/home") && extractCookieValue(request,"bjwt")!=null){
            System.out.println(request.getRequestURI());
            jwt = extractCookieValue(request,"bjwt");
            if(jwt!=null){
                username = jwtUtil.extractUsername(jwt);
            }
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                UserDetails userDetails = this.myUserService.loadUserByUsername(username);

                if(jwtUtil.validateToken(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }

            }
        }
        filterChain.doFilter(request,response);
    }

    private String  extractCookieValue(HttpServletRequest request,String cookiename){
        Cookie[] cookies = request.getCookies();
        String jwt=null;
        for (Cookie c: cookies) {
            if(cookiename.equals(c.getName())){
                jwt = c.getValue();
            }
        }
        return jwt;
    }
}
