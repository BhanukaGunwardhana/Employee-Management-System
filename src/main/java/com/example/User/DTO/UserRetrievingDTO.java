package com.example.User.DTO;

import com.example.User.Entity.Attendence;
import com.example.User.Entity.Department;
import com.example.User.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRetrievingDTO {
    private String name;
    private String mobileNumber;
    private String attendenceName;
    private String departmentName;

    public UserRetrievingDTO(User user){
        this.name=user.getName();
        this.mobileNumber=user.getMobileNumber();
        this.departmentName=user.getDepartment().getDepartmentName();
        this.attendenceName=user.getAttendence().getAttendencename();

    }
}

