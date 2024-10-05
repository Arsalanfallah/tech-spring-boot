package com.tech.dto;

import com.tech.entity.StudentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
    private Set<LessonResponse> lessonResponses=new HashSet<>();
}
