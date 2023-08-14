
package com.example.securitytask.mapper;

import com.example.securitytask.Dto.RegisterDto;
import com.example.securitytask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper{
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//    @Mapping(target = "password", expression = "java( encryptPassword(registerDto.getPassword()) )")
    User toUser(RegisterDto registerDto);

//    default String encryptPassword(String password){
//        return passwordEncoder.encode(password);
//    }
}

