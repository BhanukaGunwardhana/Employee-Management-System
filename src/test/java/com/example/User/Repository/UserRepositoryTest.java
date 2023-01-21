package com.example.User.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.User.DTO.UserCreationDTO;
import com.example.User.DTO.UserRetrievingDTO;
import com.example.User.Entity.Attendence;
import com.example.User.Entity.Department;
import com.example.User.Entity.User;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    //OnetoOne with attendence
  
    @Test
    public void deleteUserById(){
        userRepository.deleteById(1);
    
    }
    
    @Test
    public void testsaveUSerWithDepartmentwithAttendence(){
        Attendence att=Attendence.builder()
        .attendencename("good")
        .build();

        


        UserCreationDTO userCreationDTO=UserCreationDTO.builder()
        .address("address5")
        .mobileNumber("123")
        .attendence(att)
        .name("user5")
        .departmentName("Account_")
        .build();
        
        
        User user=new User();
        user.setName(userCreationDTO.getName());
        user.setAddress(userCreationDTO.getAddress());
        user.setMobileNumber(userCreationDTO.getMobileNumber());
        user.setAttendence(userCreationDTO.getAttendence());
        
        for(Department d: departmentRepository.findAll()){
            if(d.getDepartmentName().equals(userCreationDTO.getDepartmentName())){
                
                user.setDepartment(d);
            }
            

        }
        
        
        userRepository.save(user);
    }
    @Test
    public void testdeleteUserById(){
        List<User> list=userRepository.findAll();
        for (User user:list){
            
            if(user.getId()==1){
                userRepository.delete(user);
            }
        }


    }

    @Test
    public void testputUserByIdWithAttendenceWithDepartment(){
        Attendence att=Attendence.builder()
        .attendencename("updatedgood")
        .build();

        


        UserCreationDTO userCreationDTO=UserCreationDTO.builder()
        .address("upaddress2")
        .mobileNumber("up123")
        .attendence(att)
        .name("upuser2")
        .departmentName("Architech")
        .build();
        

        Optional<User> opuser= userRepository.findById(1);
        User user=opuser.get();
        user.setAddress(userCreationDTO.getAddress());
        user.setAttendence(userCreationDTO.getAttendence());
        user.setMobileNumber(userCreationDTO.getMobileNumber());
        user.setName(userCreationDTO.getName());
        
        for(Department d: departmentRepository.findAll()){
            if(d.getDepartmentName().equals(userCreationDTO.getDepartmentName())){
                
                user.setDepartment(d);
            }
        }

        userRepository.save(user);

    }

    
}
