package com.tech.service;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import com.tech.exceptions.ResourceNotFoundException;

import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest studentRequest);
    List<StudentResponse> fetchStudentByName(String name) throws ResourceNotFoundException;

    List<StudentResponse> fetchAllStudents();

    String deleteStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest newStudent);

}
