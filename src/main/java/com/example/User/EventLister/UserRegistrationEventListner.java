package com.example.User.EventLister;

import java.util.EventListener;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.User.Entity.RegisterUserVerificationToken;
import com.example.User.Event.UserRegistrationEvent;
import com.example.User.Repository.RegisterUserVerificationTokenRepository;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class UserRegistrationEventListner implements ApplicationListener<UserRegistrationEvent>{
    @Autowired
    private  RegisterUserVerificationTokenRepository registerUserVerificationTokenRepository;
    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        String token=UUID.randomUUID().toString();
        RegisterUserVerificationToken registerUserVerificationToken=new RegisterUserVerificationToken(token,event.getRegisterUser() );
        registerUserVerificationTokenRepository.save(registerUserVerificationToken);

        String url=event.getApplicationURL()+"/verifyuserregistration?token="+token;
        log.info("Click this link to verify your account :"+url);

        // TODO Auto-generated method stub
        
    }
    
}
