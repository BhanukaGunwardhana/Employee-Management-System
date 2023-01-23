package com.example.User.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.DTO.RegisterUserDTO;
import com.example.User.Entity.RegisterUser;
import com.example.User.Event.UserRegistrationEvent;
import com.example.User.Service.RegisterUserService;

@RestController
public class UserRegisterController {

    @Autowired
    RegisterUserService registerUserService;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @PostMapping("/userregistration")
    public String userRegistration(@RequestBody RegisterUserDTO registerUserDTO, final HttpServletRequest httpServletRequest){
        RegisterUser registerUser = registerUserService.userRegistration(registerUserDTO);
        String applicationURl=makeApplicationURL(httpServletRequest);
        UserRegistrationEvent userRegistrationEvent=new UserRegistrationEvent(registerUser, applicationURl);
        applicationEventPublisher.publishEvent(userRegistrationEvent);
        return "Please check your email for verification";


    }
    public String makeApplicationURL(HttpServletRequest httpServletRequest){
        return "http://"+
                httpServletRequest.getServerName()+
                ":"+
                httpServletRequest.getServerPort()+
                httpServletRequest.getContextPath();

    }
    @PostMapping("/verifyuserregistration")
    public String verifyUserRegistration(@RequestParam String token){
        return registerUserService.verifyUserRegistration(token);

    }
}
