package com.tech.dto;

import com.tech.entity.StudentType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse implements Serializable {
    private final static long serialVersionUID = 3940954723216972218L;
    private Long id;
    private String name;
    private Integer age;
    private String nationalCode;
    private StudentType studentType;
    private String birthDate;


    private Set<LessonResponse> lessonResponses=new HashSet<>();
    private Set<TeacherResponse> teacherResponses=new HashSet<>();

}
