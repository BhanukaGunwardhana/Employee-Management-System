package com.example.User.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.User.Service.RegisterUserService;

@Configuration
public class ProjectConfig {
    /*@Bean
    public UserDetailsService userDetailsService(){
        return new RegisterUserService();
    }*/
}
