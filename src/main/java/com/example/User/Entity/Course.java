package com.example.User.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.User.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private int id;
    private String name;
    
    @ManyToOne
    private User user; 
    /*public Course(int id,String name,int userid){
        this.id=id;
        this.name=name;
        this.user=new User(userid,"","");
    }*/
}
