package com.example.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.User.Entity.RegisterUser;
import com.example.User.Repository.RegisterUserRepository;

public class SecurityService implements UserDetailsService {

    @Autowired
    RegisterUserRepository registerUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (RegisterUser ru:registerUserRepository.findAll()){
            if(ru.getRegisterUserName().equals(username)){
                SecurityRegisterUser securityRegisterUser=new SecurityRegisterUser(ru);
                return securityRegisterUser;

            }
        }
        throw new UsernameNotFoundException("invalid userName");
        // TODO Auto-generated method stub
       
    }
    
}
