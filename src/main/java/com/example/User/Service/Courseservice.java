package com.example.User.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.DTO.CourseDTO;
import com.example.course.Entity.Course;
import com.example.course.Repository.Courserepo;


@Service
@Transactional
public class Courseservice {
    @Autowired
    private Courserepo courserepo;
    @Autowired 
    private ModelMapper mapper;

    public List<CourseDTO> get_coursebyid(int id) {
        List<CourseDTO> list=new ArrayList<>();
        for (Course course:courserepo.findAll()){
            if(course.getId()==id){
                list.add(mapper.map(course, CourseDTO.class));
            }
        }
        return list;
        //Optional<Course> course=courserepo.findById(id) ;
        //return mapper.map(course.get(), CourseDTO.class);
    }

    public void post_course(CourseDTO course) {
        courserepo.save(mapper.map(course, Course.class));
    }

    public void update_coursebyCourseidStudentid(int courseid,int studentid,CourseDTO coursedto) {
        Course updatecourse=mapper.map(coursedto, Course.class);
        Optional<Course> course= courserepo.findById(id);
        course.get().setId(updatecourse.getId());
        course.get().setName(updatecourse.getName());
    }

    public List<CourseDTO> get_allcourse(int userid) {
        List<CourseDTO> list= new ArrayList<>();
        for (Course course : courserepo.findAll()) {
            if(course.getUser().getId()==userid){
                list.add(mapper.map(course, CourseDTO.class));
            }
       }
       return list;
    }
    public void deletecoursebyid(int id){
        courserepo.delete(mapper.map(get_coursebyid(id), Course.class) );
    }
    

    
}
