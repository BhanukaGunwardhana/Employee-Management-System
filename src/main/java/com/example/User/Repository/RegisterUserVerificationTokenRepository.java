package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.Entity.RegisterUserVerificationToken;

@Repository
public interface RegisterUserVerificationTokenRepository extends JpaRepository<RegisterUserVerificationToken,Integer>{
    
}
