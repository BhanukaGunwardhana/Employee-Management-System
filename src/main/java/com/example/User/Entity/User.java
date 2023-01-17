package com.example.User.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private int id;
    private String name;
    private String mobileNumber;
    private String address;

    @OneToOne(
        cascade = CascadeType.ALL
        
    
    )
    @JoinColumn(
        name = "attendence_Id",
        referencedColumnName = "attendenceId"
    )
    private Attendence attendence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "department_id",
        referencedColumnName = "departmentId"
    )

    private Department department;


   
    
}
