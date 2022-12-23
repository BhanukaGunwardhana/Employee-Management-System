package com.example.derepo.Controller;

import com.example.derepo.DTO.UserDTO;
import com.example.derepo.Entity.User;
import com.example.derepo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    /*@GetMapping("/getuser")
    public List<UserDTO> getUser(){
        return  userService.getUser();
       // return "demorepo_post";
    }
    @PostMapping("/postuser")
    public UserDTO postUser(@RequestBody UserDTO userDTO){
      return  userService.saveUser(userDTO);
    //    return "demorepo_post";
    }
    @GetMapping("/getuserbyidfromlist/{id}")
    /*public UserDTO getuserbyidfromlist(@PathVariable int id){
     //int id=Integer.parseInt(id_);
      return userService.getuserbyid_fromlist(id);

    }
    @PutMapping ("/postuserbyidfromlist/{id}")
    public String changeuserbyidfromlist(@PathVariable int id, @RequestBody UserDTO user){
      //int intid=Integer.parseInt(id);
      userService.changeuserbyid_fromlist(id, user);
      return "User saving id successful";

    }
    @GetMapping("/getuserfromlist")
    public List<UserDTO> getuserfromlist(){
      return userService.getuser_fromlist();
    }
    @DeleteMapping ("/deleteuserfromlist/{id}")
    public String removeuserbyidfromlist(@PathVariable int id){
       return userService.deleteuserbyid_fromlist(id);
    }
    @PostMapping ("/addusertolist")
    public List<UserDTO> addusertolist(@RequestBody UserDTO user){
      return userService.adduser_tolist(user);
    }*/
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

}
