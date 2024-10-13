package com.tech.dto;

import com.tech.entity.StudentType;
import com.tech.entity.TeacherType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse implements Serializable {
    private final static long serialVersionUID = 3940954723216972216L;
    private Long id;
    private String name;
    private Integer age;
    private String nationalCode;
    private TeacherType teacherType;
    private String birthDate;


    private Set<StudentResponse> studentResponses=new HashSet<>();
}
