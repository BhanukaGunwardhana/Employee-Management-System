package com.example.User.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.course.Entity.Course;

public interface Courserepo extends CrudRepository <Course,Integer> {
    
}
