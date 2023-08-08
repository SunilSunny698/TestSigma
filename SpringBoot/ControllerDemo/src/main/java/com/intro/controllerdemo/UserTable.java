package com.intro.controllerdemo;

import com.intro.controllerdemo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTable {
    public List<User> usersList = new ArrayList<>();

    public void addUser(User u){
        usersList.add(u);
    }
    public void deleteUser(User u) {
        usersList.remove(u);
    }

}
