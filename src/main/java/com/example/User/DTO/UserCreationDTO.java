package com.example.User.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.example.User.Entity.Attendence;
import com.example.User.Entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserCreationDTO {
  
 
    private String name;
    private String mobileNumber;
    private String address;
    private Attendence attendence;
    private String departmentName;
}
