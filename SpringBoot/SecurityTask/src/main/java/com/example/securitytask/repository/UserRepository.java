package com.example.securitytask.repository;

import com.example.securitytask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);
    User findByEmail(String email);

    List<User> findByUsernameStartingWithAndApi(String prefix, boolean api);
}
