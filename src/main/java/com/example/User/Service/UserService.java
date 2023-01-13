package com.example.User.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.DTO.UserDTO;
import com.example.User.Entity.User;
import com.example.User.Repository.UserRepository;
import com.example.User.UserRepository_2.UserRepo_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo_2 userRepo_2;

    public UserDTO saveUser(UserDTO userdto){
        userRepository.save(modelMapper.map(userdto,User.class));
        return userdto;
    }
    public List<UserDTO> getUser(){
        List<User> list1=userRepository.findAll();
        return modelMapper.map(list1,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO getUserById(int id){
        List<User> list=userRepository.findAll();
        for(User user: list){
            if(user.getId()==id){
                return modelMapper.map(user, UserDTO.class);
            }
        }
        return null;
    }
    public void putUser(int id,UserDTO userdto){
        User updateuser=modelMapper.map(userdto, User.class);
        Optional<User> userdtotoupdate=userRepository.findById(id);
        userdtotoupdate.get().setId(updateuser.getId());
        userdtotoupdate.get().setName(updateuser.getName());
        userdtotoupdate.get().setAddress(updateuser.getAddress());   
    }
    public void deleteUserById(int id){
        List<User> list=userRepository.findAll();
        for (User user:list){
            if(user.getId()==id){
                user=null;
            }
        }
    }
 
    // Service methods without using DTO
    /* 
    public void addall(User user){
        userRepo_2.save(user);
    }
    public List<User> getall(){
        List <User> list = new ArrayList<>();        
        // return (List<User>) userRepo_2.findAll();
        for (User user: userRepo_2.findAll()){
            list.add(user);
        }
        return list;
    }
    public void put_user(User user, int id) {
       /*for(User user2: userRepo_2.findAll()) {
            if(user2.getId()==id){
                user2.setId(user.getId());
                user2.setName(user.getName());
                user2.setAddress(user.getAddress());
            }
       }*/
       /* 
       for (User user3: userRepo_2.findAll()){
            if(user3.getId()==id){
                userRepo_2.save(user);
            }
       }
    
    }
    public Optional<User> get_userbyid(int id){
        return userRepo_2.findById(id);
    }
    public void delete_userbyid(int id) {
        userRepo_2.deleteById(id);
    }
    */
}
