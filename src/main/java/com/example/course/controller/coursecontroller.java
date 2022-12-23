package com.example.course.controller;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.Entity.Course;
import com.example.course.Service.Courseservice;
import com.example.derepo.Entity.User;



@RestController
@RequestMapping ("api/v2/user")
@CrossOrigin
public class coursecontroller {
    @Autowired
    private Courseservice courseservice;
    @GetMapping ("course/{id}")
    public Optional<Course> getcoursebyid(@PathVariable int id){
        return courseservice.get_coutsebyid(id);
    }
    @PostMapping("/derepo/{userid}/course")
    public String postcourse(@PathVariable int userid, @RequestBody Course course)   
    {

        course.setUser(new User(userid,"",""));
        courseservice.post_course(course);
        return "Post have been made";
    }
    @PutMapping("/derepo/{userid}/course/{id}")
    public String updatecourse(@PathVariable int id,@PathVariable int userid, @RequestBody Course course ){

        if (userid==course.getUser().getId()){
            courseservice.update_course(course);
            return "Put has been made with same user id";
        }else{
            course.setUser(new User(userid,"",""));
            courseservice.update_course(course);
            return " Put has bee made with diffrent user id";
        }
        
        

    }
    @GetMapping ("/derepo/{userid}/course")
    public List<Course> getallcourse(@PathVariable int userid){
        return courseservice.get_allcourse(userid);

    }
    
    
}
