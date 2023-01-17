package com.example.User.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.User.DTO.UserCreationDTO;
import com.example.User.DTO.UserDTO;
import com.example.User.Entity.Attendence;
import com.example.User.Entity.Department;
import com.example.User.Entity.User;

public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    
    void testSaveUserwithattendence() {
        Attendence att=Attendence.builder()
        .attendence("hvh")
        .build();

        Department department=Department.builder()
        .departmentName("iabic")
        .build();


        UserCreationDTO userCreationDTO=UserCreationDTO.builder()
        .id(10)
        .address("address__")
        .mobileNumber("iivh")
        .attendence(att)
        .name("usvui")
        .department(department)
        .build();
        
        userService.saveUserwithattendence(userCreationDTO);
        
    }
}
