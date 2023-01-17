package com.example.User.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.Entity.Department;
import com.example.User.Repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public void getDepartmentsWithNoOfEmployees(){
        Set<Integer>set=new HashSet<>();
        Set<Department> deptSet=new HashSet<>();
        List<Department>list=departmentRepository.findAll();
        Map<String,Integer> map=new HashMap<>();
        for(Department d:departmentRepository.findAll()){
            set.add(d.getDepartmentId());
            if(!set.contains(d.getDepartmentId())){
                deptSet.add(d);
            }
        } 
        for(Department d_: deptSet){
            int count=0;
            for(Department d: list){
                if(d.getDepartmentId()==d_.getDepartmentId()){
                    count++;
                }
               
            }
            map.put(d_.getDepartmentName(), count);

        }
        for (Entry<String, Integer> m:map.entrySet()){
            System.out.println(m.getKey()+"->"+m.getValue());
        }

    }
    
}
