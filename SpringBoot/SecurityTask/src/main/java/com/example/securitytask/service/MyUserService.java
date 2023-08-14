package com.example.securitytask.service;

import com.example.securitytask.Dto.RegisterDto;
import com.example.securitytask.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserService extends UserDetailsService {
    User save(User user);
    User modifyApiVal(String username,boolean val);
}
