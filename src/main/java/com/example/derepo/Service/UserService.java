package com.example.derepo.Service;

import com.example.derepo.DTO.UserDTO;
import com.example.derepo.Entity.User;
import com.example.derepo.Repository.UserRepository;
import com.example.derepo.UserRepository_2.UserRepo_2;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    /*List <UserDTO> list=new ArrayList<>(Arrays.asList(new UserDTO(1,"Name_1","Address_1"), new UserDTO(2,"Name_2","Address_1"),new UserDTO(3,"Name_3","Address_3")
    )) ; */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo_2 userRepo_2;
    /*public UserDTO saveUser(UserDTO userdto){

        userRepository.save(modelMapper.map(userdto,User.class));
        return userdto;

    }
    public List<UserDTO> getUser(){
        List<User> list1=userRepository.findAll();
        return modelMapper.map(list1,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public List<UserDTO> getuser_fromlist(){
        return list;
    }
    public UserDTO getuserbyid_fromlist(int id){

        for (UserDTO i: list){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
       // return list.stream().filter(t ->t.getId()==id ).findFirst().get();
    }
    public void changeuserbyid_fromlist(int id, UserDTO user){
        for (UserDTO i:list){
            if(i.getId()==id){
                i.setId(user.getId());
                i.setName(user.getName());
                i.setAddress(user.getAddress());
            }
        }
    }
    public String deleteuserbyid_fromlist(int id){
        
        list.removeIf(t -> t.getId()==id);
        return "Element having id of"+id+" have been removed"; 
    }
    public List<UserDTO> adduser_tolist(UserDTO user) {
        list.add(user);
        return list;
    }*/
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
}
