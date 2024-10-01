package com.tech.service;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest studentRequest);
    List<StudentResponse> fetchStudentByName(String name);

    List<StudentResponse> fetchAllStudents();

    String deleteStudentById(Integer id);
}
