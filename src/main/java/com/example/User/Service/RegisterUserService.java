package com.example.User.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.DTO.RegisterUserDTO;
import com.example.User.Entity.RegisterUser;
import com.example.User.Entity.RegisterUserVerificationToken;
import com.example.User.Repository.RegisterUserRepository;
import com.example.User.Repository.RegisterUserVerificationTokenRepository;

@Service
@Transactional
public class RegisterUserService implements UserDetailsService{

    @Autowired
    RegisterUserRepository registerUserRepository;
    @Autowired
    RegisterUserVerificationTokenRepository registerUserVerificationTokenRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public RegisterUser userRegistration(RegisterUserDTO registerUserDTO){
        //RegisterUser registerUser=modelMapper.map(registerUserDTO, RegisterUser.class);
        RegisterUser registerUser= new RegisterUser();
        
        registerUser.setRegisterUserName(registerUserDTO.getUserName());
        registerUser.setRegisterUserEmailId(registerUserDTO.getEmailId());
        registerUser.setPassword(passwordEncoder.encode(registerUserDTO.getPassWord()));
        registerUser.setRole("User");
        registerUserRepository.save(registerUser);
        return registerUser;
    }
    public String verifyUserRegistration(String token){
        RegisterUser registerUser=null;
        for (RegisterUserVerificationToken rUserVerificationToken : registerUserVerificationTokenRepository.findAll()){
            
            if(rUserVerificationToken.getRegisterUserVerificationTokenName().equals(token)){
                registerUser=rUserVerificationToken.getRegisterUser();
                registerUser.setEnableRegisterUser(true);
                registerUserRepository.save(registerUser);
                return "user registration completed";
                
            }
            

        }
        if(registerUser==null){
            return "Invalid token";
        }
        return null;
        //return token;
        
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
