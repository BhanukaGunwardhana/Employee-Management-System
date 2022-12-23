package com.example.course.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.Entity.Course;
import com.example.course.Repository.Courserepo;


@Service
@Transactional
public class Courseservice {
    @Autowired
    private Courserepo courserepo;

    public Optional<Course> get_coutsebyid(int id) {
        return courserepo.findById(id) ;
    }

    public void post_course(Course course) {
        courserepo.save(course);
    }

    public void update_course(Course course) {
        courserepo.save(course);
    }

    public List<Course> get_allcourse(int userid) {
        List<Course> list= new ArrayList<>();
        for (Course course : courserepo.findAll()) {
            if(course.getUser().getId()==userid){
                list.add(course);
            }
       }
       return list;
    }
    /*public String delete_coursebyid(){

    }*/

    
}
