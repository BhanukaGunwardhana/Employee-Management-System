package com.example.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.DTO.DepartmentDTO;
import com.example.User.Repository.DepartmentRepository;
import com.example.User.Service.DepartmentService;

@RestController
@RequestMapping(value = "/api/v1/department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/postdepartment")
    public void postDepartment(@RequestBody DepartmentDTO deaprDepartmentDTO){
        departmentService.creatDepartments(deaprDepartmentDTO);
    }
    @DeleteMapping("/deletedepartment/{id}")
    public void deleteDepartmentByDepartmentId(int id){
        departmentService.deleteDepartments(id);
    }
}
