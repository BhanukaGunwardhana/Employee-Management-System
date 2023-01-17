package com.example.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentCreatingDTO {
 private int departmentId;
 private String DepartmentName;
 
    
}
