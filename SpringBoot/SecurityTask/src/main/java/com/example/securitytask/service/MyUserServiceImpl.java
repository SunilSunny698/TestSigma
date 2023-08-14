package com.example.securitytask.service;

import com.example.securitytask.Dto.RegisterDto;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MyUserServiceImpl implements MyUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        else{
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getAuthorities(user.getRole()));
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String roles){
        return Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public User modifyApiVal(String username, boolean val) {
        User u = userRepository.findByUsername(username);
        u.setApi(val);
        return userRepository.save(u);
    }
}

