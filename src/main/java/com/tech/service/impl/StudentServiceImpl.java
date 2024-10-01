package com.tech.service.impl;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import com.tech.mapper.StudentMapper;
import com.tech.repository.StudentRepository;
import com.tech.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student=studentMapper.requestToEntity(studentRequest);
        student= studentRepository.save(student);
        return studentMapper.entityToResponse(student);

    }

    @Override
    public List<StudentResponse> fetchStudentByName(String name) {
        List<StudentResponse> studentResponses=new ArrayList<>();
        List<Student> studentList=  studentRepository.findByName(name);

        if(studentList!=null && !studentList.isEmpty()){
            studentResponses=studentMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }

    @Override
    public List<StudentResponse> fetchAllStudents() {
        List<StudentResponse> studentResponses=new ArrayList<>();
        List<Student> studentList=  studentRepository.findAll();

        if(studentList!=null && !studentList.isEmpty()){
            studentResponses=studentMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }
    @Override
    public String deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
        return String.format("Student with id {%d} is deleted",id);
    }
}
