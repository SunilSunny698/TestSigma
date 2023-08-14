package com.example.securitymysql;

import com.example.securitymysql.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityMysqlApplication.class, args);
    }

}
