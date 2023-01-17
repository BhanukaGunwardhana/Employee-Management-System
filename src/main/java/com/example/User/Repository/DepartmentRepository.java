package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.Entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    
}
