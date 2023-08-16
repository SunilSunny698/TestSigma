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
//@WebFilter(
//        filterName = "HomeFilter",
//        urlPatterns = {"/home/*","/token/*"}
//)
public class HomeFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if(request.getRequestURI().matches("/v1(.*)")){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt;
        String username = null;
        jwt = extractCookieValue(request);
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

        filterChain.doFilter(request,response);
    }
    private String  extractCookieValue(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String jwt=null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("bjwt".equals(c.getName())) {
                    jwt = c.getValue();
                }
            }
        }
        return jwt;
    }
}
