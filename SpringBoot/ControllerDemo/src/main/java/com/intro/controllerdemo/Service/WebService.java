package com.intro.controllerdemo.Service;

import com.intro.controllerdemo.Repository.UserRepository;
import com.intro.controllerdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.List;

@Service
public class WebService {
    @Autowired
    private final UserRepository userRepo;


    public WebService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User getUser(int id){

        return userRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public boolean deleteUser(int id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
}
