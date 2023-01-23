package com.example.User.Event;

import org.springframework.context.ApplicationEvent;

import com.example.User.Entity.RegisterUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserRegistrationEvent extends ApplicationEvent {
    private RegisterUser registerUser;
    private String applicationURL;
    public UserRegistrationEvent(RegisterUser registerUser,String applicationURL) {
        super(registerUser);
        this.registerUser=registerUser;
        this.applicationURL=applicationURL;
        //TODO Auto-generated constructor stub
    }
    
}
