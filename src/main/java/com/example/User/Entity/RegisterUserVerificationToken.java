package com.example.User.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserVerificationToken {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registerUserVerificationTokenId;
    private String registerUserVerificationTokenName;

    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "verificationToken_registerUser",
        referencedColumnName = "registerUserId"
        
    )
    private RegisterUser registerUser;
    public RegisterUserVerificationToken(String token,RegisterUser registerUser){
        super();
        this.registerUserVerificationTokenName=token;
        this.registerUser=registerUser;
    }


}
