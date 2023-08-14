package com.example.securitytask.config;

import com.example.securitytask.Dto.RegisterDto;
import com.example.securitytask.jwt.JwtUtil;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import com.example.securitytask.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MyUserService userService;


    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = null;
        String jwt = null;
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            String provider = determineAuthenticationProvider(authentication);
            DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
            String username = userDetails.getAttribute("email") != null ?
                    userDetails.getAttribute("email") :
                    userDetails.getAttribute("login") + "@gmail.com";

            if (userRepository.findByEmail(username) == null) {
                User user = new User();
                user.setEmail(username);
                user.setUsername(authentication.getName());
                user.setPassword("Dummy");
                user.setRole("USER");
                if(provider.equals("google")){
                    user.setProvider(User.Provider.GOOGLE);
                }else if(provider.equals("github")){
                    user.setProvider(User.Provider.GITHUB);
                } else{
                    user.setProvider(User.Provider.UNKNOWN);
                }
                user.setProvider(User.Provider.GOOGLE);
                userService.save(user);

            }
            jwt = jwtUtil.generateToken(userRepository.findByUsername(authentication.getName()).getUsername());
        }
        else if(authentication.getPrincipal() instanceof UserDetails){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            jwt = jwtUtil.generateToken(userDetails);

        }
        Cookie cookie = new Cookie("bjwt",jwt);
        cookie.setMaxAge(1200);
        cookie.setPath("/");
        response.addCookie(cookie);
        redirectUrl = "/home";
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
    private String determineAuthenticationProvider(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

            if (oauthToken.getAuthorizedClientRegistrationId().equals("google")) {
                return "google";
            } else if (oauthToken.getAuthorizedClientRegistrationId().equals("github")) {
                return "github";
            }
        }

        return "unknown";
    }
}
