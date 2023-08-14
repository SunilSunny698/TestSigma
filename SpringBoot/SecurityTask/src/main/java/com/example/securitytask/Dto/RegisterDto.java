package com.example.securitytask.Dto;


import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String repeat;
    private String email;

}
