package com.example.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;
import com.example.User.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getuser")
    // get full user details
    public List<UserDTO> getUser(){
        return  userService.getUser();
       
    }
    @PostMapping("/postuser")
    // add user to the database
    public UserDTO postUser(@RequestBody UserDTO userDTO){
      return  userService.saveUser(userDTO);
    
    }
    @GetMapping("/getuserbyid/{id}")
    // get userdetails of a specific user  
    public UserDTO getuserbyid(@PathVariable int id){
      return userService.getUserById(id);

    }
    @PutMapping ("/postuserbyid/{id}")
    // update details of a specific user
    public String changeuserbyid(@PathVariable int id, @RequestBody UserDTO user){
      userService.putUser(id, user);
      return "User saving id successful";

    }
    @DeleteMapping ("/deleteuser/{id}")
    // delete specific user
    public void removeuserbyid(@PathVariable int id){
       userService.deleteUserById(id);
    }
    
    
    // controller methods without using DTO
    /* 
    @GetMapping ("/derepo")
    public List<User> getalluser(){
      return userService.getall();
    }
    @PostMapping ("/derepo")
    public String adduser(@RequestBody User user){
       userService.addall(user);
       return "User has been added";
    }
    @PutMapping ("/derepo/{id}")
    public String putuser(@RequestBody User user, @PathVariable int id){
      userService.put_user(user,id);
      return "User has been updated";
    }
    @GetMapping ("derepo/{id}")
    public Optional<User> getuserbyid(@PathVariable int id){
      return userService.get_userbyid(id);
    }
    @DeleteMapping ("derepo/{id}")
    public String deleteuserbyid(@PathVariable int id){
      userService.delete_userbyid(id);
      return "user deleted";
    }
    */
}
