package com.example.securitytask.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role = "ROLE_USER";
    private Provider provider=Provider.LOCAL;
    private boolean api = false;
    public enum Provider{
        LOCAL,GOOGLE,GITHUB,UNKNOWN
    }

}
