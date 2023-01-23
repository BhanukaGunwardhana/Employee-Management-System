package com.example.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.User.DTO.UserCreationDTO;
import com.example.User.DTO.UserDTO;
import com.example.User.DTO.UserRetrievingDTO;
import com.example.User.Entity.User;
import com.example.User.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String helloUser(){
      return "Hello!";
    }
    @GetMapping("/getuser")
    // get full user details
    public List<UserRetrievingDTO> getUser(){
        return  userService.getUser();
       
    }
    @PostMapping("/postuser")
    // add user to the database
    public UserCreationDTO postUser(@RequestBody UserCreationDTO userCreationDTO){
      return userService.saveUSerWithDepartmentwithAttendence(userCreationDTO);
      
    }
    @GetMapping("/getuserbyid/{id}")
    // get userdetails of a specific user  
    public UserRetrievingDTO getuserbyid(@PathVariable int id){
      return userService.getUserByIdWithAttendenceWithDepartment(id);

    }
    @GetMapping("/getuserbydepartmentname/{departmentName}")
    public List<UserRetrievingDTO> getUserByDepartmentName(@PathVariable String departmentName){
      return userService.getUserwithattendencewithDepartment(departmentName);
    }
    @GetMapping("/getuserbyuserid/<id>")
    public UserRetrievingDTO getUserByUserId(int id){
      return userService.getUserByIdWithAttendenceWithDepartment(id);
    }
    @PutMapping ("/postuserbyid/{id}")
    // update details of a specific user
    public String changeuserbyid (@RequestBody UserCreationDTO userCreationDTO, @PathVariable int id){
      userService.putUserByIdWithAttendenceWithDepartment(id, userCreationDTO);
      return "User saving id successful";

    }
    @DeleteMapping ("/deleteuser/{id}")
    // delete specific user
    public void removeuserbyid(@PathVariable int id){
       userService.deleteUserById(id);
    }
    @DeleteMapping ("/deleteuserbydepartmentname/{departmentName}")
    public void deleteUserByDepartmentName(String departmentName){
      userService.deleteUserByDepartment(departmentName);
    }
    
    
    
}
