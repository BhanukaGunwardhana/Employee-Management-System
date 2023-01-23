package com.example.User.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.User.Service.RegisterUserService;
import com.example.User.Service.SecurityService;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        return new SecurityService();
    }
    
}
