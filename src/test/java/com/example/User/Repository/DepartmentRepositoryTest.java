package com.example.User.Repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.User.Entity.Department;

@SpringBootTest
public class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;
    @Test
    public void testcreatDepartments(){
        Department department=Department.builder()
        .departmentName("Architech")
        .build();

        departmentRepository.save(department);

    }
    @Test
    public void testdeleteDepartments(){
        Optional<Department> opDepartment =departmentRepository.findById(2);
         Department department=opDepartment.get();

        departmentRepository.delete(department);
    }

}
