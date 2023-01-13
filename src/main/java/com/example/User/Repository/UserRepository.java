package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.Entity.Course;
import com.example.User.Entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{
     //Select students having same address
    @Query(value = "SELECT name AS studentshavingsameaddress,address  FROM USER GROUP BY address")
    User studentshavingsameaddress();

    //select students having same name
    @Query(value = "SELECT id,name,count(name) AS studentcount FROM USER GROUP BY name ")
    User studentshavingsamename();

   


}
