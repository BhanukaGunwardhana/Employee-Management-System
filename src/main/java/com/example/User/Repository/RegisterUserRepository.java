package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.Entity.RegisterUser;
@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser,Integer>{
    
}
