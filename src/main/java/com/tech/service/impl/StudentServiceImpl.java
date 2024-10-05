package com.tech.service.impl;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import com.tech.exceptions.ResourceNotFoundException;
import com.tech.mapper.StudentMapper;
import com.tech.repository.StudentRepository;
import com.tech.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    @Transactional
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = studentMapper.requestToEntity(studentRequest);
        student = studentRepository.save(student);
        return studentMapper.entityToResponse(student);

    }

    @Override
    public List<StudentResponse> fetchStudentByName(String name) throws ResourceNotFoundException {
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<Student> studentList= studentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (studentList != null && !studentList.isEmpty()) {
            studentResponses = studentMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }

    @Override
    public List<StudentResponse> fetchAllStudents() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();

        if (studentList != null && !studentList.isEmpty()) {
            studentResponses = studentMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }

    @Override
    public String deleteStudentById(Long id) {
        log.info("Delete Client with ID ={} ", id);
        studentRepository.deleteById(id);
        return String.format("Student with id {%d} is deleted", id);
    }

    @Override
    @Transactional()
    public StudentResponse updateStudent(Long id, StudentRequest newStudent) {
        log.info("Update Client with ID ={} ", id);
        StudentResponse response = null;
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student clt = studentOptional.get();
            clt.setName(newStudent.getName());
            clt.setAge(newStudent.getAge());
            clt.setNationalCode(newStudent.getNationalCode());
            Student student = studentRepository.save(clt);
            response=studentMapper.entityToResponse(student);
        }

        return response;
    }
}
