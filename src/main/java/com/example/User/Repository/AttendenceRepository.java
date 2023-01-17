package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.Entity.Attendence;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence,Integer> {
    
}
