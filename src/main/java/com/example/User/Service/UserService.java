package com.example.User.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.DTO.DepartmentDTO;
import com.example.User.DTO.UserCreationDTO;
import com.example.User.DTO.UserDTO;
import com.example.User.DTO.UserRetrievingDTO;
import com.example.User.Entity.Department;
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

    //With DTO ManytoOne relation with department
    public  DepartmentDTO selectDepartmentByUserId(int id){
        Optional<User> opuser =userRepository.findById(id);
        User user=opuser.get();
        return(modelMapper.map(user.getDepartment(), DepartmentDTO.class) );
    }
    public void updateDepartmentByUserId(int id,DepartmentDTO departmentCreatingDTO){
        Optional<User> opuser =userRepository.findById(id);
        User user=opuser.get();
        user.setDepartment(modelMapper.map(departmentCreatingDTO, Department.class));


    }

    
    //with DTO  OnetoOne relation with attendence
    public void saveUserwithattendence(UserCreationDTO userCreationDTO){
        userRepository.save(modelMapper.map(userCreationDTO,User.class));
       
        
    }
    public List<UserRetrievingDTO> getUserwithattendence(){
        List<User> list1=userRepository.findAll();
        List<UserRetrievingDTO>list=new ArrayList<>();
        for (User u:list1){
            list.add(modelMapper.map(u, UserRetrievingDTO.class));
        }
        return list;
        
    }
    public UserRetrievingDTO getUserByIdWithAttendence(int id){
        List<User> list=userRepository.findAll();
        for(User user: list){
            if(user.getId()==id){
                return modelMapper.map(user, UserRetrievingDTO.class);
            }
        }
        return null;

    }
    public void putUserByIdWithAttendence(int id, UserCreationDTO userCreationDTO){
        Optional<User> opuser= userRepository.findById(id);
        User user=opuser.get();
        user.setAddress(userCreationDTO.getAddress());
        user.setAttendence(userCreationDTO.getAttendence());
        user.setMobileNumber(userCreationDTO.getMobileNumber());
        user.setName(userCreationDTO.getName());
        userRepository.save(user);

    } 

    


    
    //with DTO singletable
    public UserDTO saveUser(UserDTO userDTO){
        userRepository.save(modelMapper.map(userDTO,User.class));
        
        return userDTO;
    }
    public List<UserDTO> getUser(){
        List<User> list1=userRepository.findAll();
        List<UserDTO>list=new ArrayList<>();
        for (User u:list1){
            list.add(modelMapper.map(u, UserDTO.class));
        }
        return list;
        //return modelMapper.map(list1,new TypeToken<List<UserDTO>>(){}.getType());
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
    public void putUser(UserDTO userdto){
        User updateuser=modelMapper.map(userdto, User.class);
        userRepository.save(updateuser);
        //Optional<User> userdtotoupdate=userRepository.findById(id);
        
       /*for(User u: userRepository.findAll()){
            if(u.getId()==userdto.getId()){
                u.setId(updateuser.getId());
                u.setName(updateuser.getName());
                u.setAddress(updateuser.getAddress());   
            }
        }*/
        
    }
    public void deleteUserById(int id){
        List<User> list=userRepository.findAll();
        for (User user:list){
            
            if(user.getId()==id){
                userRepository.delete(user);
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
