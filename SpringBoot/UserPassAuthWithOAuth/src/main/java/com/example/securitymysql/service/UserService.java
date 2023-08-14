package com.example.securitymysql.service;

import com.example.securitymysql.dto.LoginDto;
import com.example.securitymysql.dto.NewUserDto;
import com.example.securitymysql.models.User;
import com.example.securitymysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(NewUserDto newUserDto){
        User u = new User();
        u.setUsername(newUserDto.getUsername());
        u.setPassword(newUserDto.getPassword());
        u.setEmail(newUserDto.getEmail());
        u.setRoles(newUserDto.getRoles());
        u.setActive(true);
        userRepository.save(u);
    }

}
