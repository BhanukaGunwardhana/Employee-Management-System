package com.example.User.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.User.DTO.UserRetrievingDTO;
import com.example.User.Entity.Attendence;
import com.example.User.Entity.Department;
import com.example.User.Entity.User;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    //OnetoOne with attendence
   @Test
    public void saveUser(){
        Attendence attendence=Attendence.builder()
        .attendence("Good")
        .build();



        User user=User.builder()
        .name("user3")
        .address("addres3")
        .mobileNumber("mobilenumber3")
        .attendence(attendence)
        .build();

        userRepository.save(user);
    }

    @Test
    public void putUserByIdWithAttendence(){

        Attendence attendence=Attendence.builder()
        .attendence("bad")
        .build();



        User chuser=User.builder()
        .name("user2")
        .address("addres2")
        .mobileNumber("mobilenumber2")
        .attendence(attendence)
        .build();
        

        Optional<User> opuser= userRepository.findById(1);
        User user=opuser.get();
        user.setAddress(chuser.getAddress());
        user.setAttendence(chuser.getAttendence());
        user.setMobileNumber(chuser.getMobileNumber());
        user.setName(chuser.getName());

        userRepository.save(user);

    }
    @Test
    public void deleteUserById(){
        userRepository.deleteById(1);
    
    }
    @Test
    public void saveUserwithdepartmentandattendence(){
        Attendence attendence=Attendence.builder()
        .attendence("Good")
        .build();

        Department department=Department.builder()
        .departmentName("Irrigation")
        .build();


        User user=User.builder()
        .name("user4")
        .address("addres3")
        .mobileNumber("mobilenumber3")
        .attendence(attendence)
        .build();

        userRepository.save(user);

    }
    @Test
    public void testgetUserwithattendence(){
        List<User> list1=userRepository.findAll();
        List<UserRetrievingDTO>list=new ArrayList<>();
        for (User u:list1){
            list.add(modelMapper.map(u, UserRetrievingDTO.class));
        }
        System.out.println(list.toString());

    }
}
