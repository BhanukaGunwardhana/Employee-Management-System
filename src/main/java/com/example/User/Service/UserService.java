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
import com.example.User.Repository.DepartmentRepository;
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
    private DepartmentRepository departmentRepository;

    //With DTO ManytoOne relation with department
    public  DepartmentDTO selectDepartmentByUserId(int id){
        Optional<User> opuser =userRepository.findById(id);
        User user=opuser.get();
        return(modelMapper.map(user.getDepartment(), DepartmentDTO.class) );
    }
    /*public void updateDepartmentByUserId(int id,DepartmentDTO departmentCreatingDTO){
        Optional<User> opuser =userRepository.findById(id);
        User user=opuser.get();
        user.setDepartment(modelMapper.map(departmentCreatingDTO, Department.class));


    }*/
    public List<UserRetrievingDTO> getUser(){
        List<User> list1=userRepository.findAll();
        List<UserRetrievingDTO>list=new ArrayList<>();
        for (User u:list1){
           
            list.add(new UserRetrievingDTO(u));    
        }
        return list;
    }


    public UserCreationDTO saveUSerWithDepartmentwithAttendence(UserCreationDTO userCreationDTO){
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
        if(user.getDepartment()==null){
            throw new IllegalStateException();
        }
        userRepository.save(user);
        return userCreationDTO;

    }

    public List<UserRetrievingDTO> getUserwithattendencewithDepartment(String departmentName){
        List<User> list1=userRepository.findAll();
        List<UserRetrievingDTO>list=new ArrayList<>();
        for (User u:list1){
            if(u.getDepartment().getDepartmentName().equals(departmentName)){
                list.add(new UserRetrievingDTO(u));
        
            }
        }
        return list;
    }

    public UserRetrievingDTO getUserByIdWithAttendenceWithDepartment(int id){
        List<User> list=userRepository.findAll();
        for(User user: list){
            if(user.getId()==id){
                //return modelMapper.map(user, UserRetrievingDTO.class);
                return new UserRetrievingDTO(user);
            }
        }
        return null;

    }

    public void putUserByIdWithAttendenceWithDepartment(int id, UserCreationDTO userCreationDTO){
        Optional<User> opuser= userRepository.findById(id);
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
    public void deleteUserByDepartment(String departmentName){
        for(User user:userRepository.findAll()){
            if(user.getDepartment().getDepartmentName().equals(departmentName)){
                userRepository.delete(user);
            }
        }
    }
    public void deleteUserById(int id){
        List<User> list=userRepository.findAll();
        for (User user:list){
            
            if(user.getId()==id){
                userRepository.delete(user);
            }
        }
    }

    
    
    
    
    //with DTO  OnetoOne relation with attendence
    /* 
    public void saveUserwithattendence(UserCreationDTO userCreationDTO){
        userRepository.save(modelMapper.map(userCreationDTO,User.class));
        
       
        
    }
    public List<UserRetrievingDTO> getUserwithattendence(){
        List<User> list1=userRepository.findAll();
        List<UserRetrievingDTO>list=new ArrayList<>();
        for (User u:list1){
            list.add(new UserRetrievingDTO(u));
        }
        return list;
        
    }
    public UserRetrievingDTO getUserByIdWithAttendence(int id){
        List<User> list=userRepository.findAll();
        for(User user: list){
            if(user.getId()==id){
                //return modelMapper.map(user, UserRetrievingDTO.class);
                return new UserRetrievingDTO(user);
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

    */


    
    //with DTO singletable
    /* 
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
        
        
    }
    */
    
 
    
}
