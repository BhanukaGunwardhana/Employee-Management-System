package com.example.User.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.DTO.DepartmentDTO;
import com.example.User.Entity.Department;
import com.example.User.Repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    public void creatDepartments(DepartmentDTO departmentDTO){
        departmentRepository.save(modelMapper.map(departmentDTO, Department.class));

    }
    public void deleteDepartments(int id){
        Optional<Department> opDepartment =departmentRepository.findById(id);
         Department department=opDepartment.get();

        departmentRepository.delete(department);
    }

    


    
}
