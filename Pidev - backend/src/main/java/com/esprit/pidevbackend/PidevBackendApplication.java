package com.esprit.pidevbackend;

import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PidevBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PidevBackendApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
/*
    @Bean
    CommandLineRunner run (UserService userService){
        return args -> {
          userService.saveRole(new Role(null,"ROLE_USER"));
          userService.saveRole(new Role(null,"ROLE_MANAGER"));
          userService.saveRole(new Role(null,"ROLE_ADMIN"));
          userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null,"Jhon travolta","jhon","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"Whill Smith","will","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"Jim Carry","jim","1234",new ArrayList<>()));
          userService.saveUser(new User(null,"Arnold Shwarzeneger","arnold","1234",new ArrayList<>()));


          userService.addRoleToUser("jhon","ROLE_USER");
          userService.addRoleToUser("will","ROLE_MANAGER");
          userService.addRoleToUser("jim","ROLE_ADMIN");
          userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
          userService.addRoleToUser("arnold","ROLE_ADMIN");
          userService.addRoleToUser("arnold","ROLE_USER");

        };
    }*/
}
