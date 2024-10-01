package com.tech.service;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import com.tech.mapper.StudentMapper;
import com.tech.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper mapper;

    @Autowired
    private StudentService studentService;
    @Test
    public void testSaveStudent() {
        // Given
        Student student = new Student("John", 15,0);
        StudentRequest studentRequest=mapper.entityToRequest(student);
        Mockito.when(studentRepository.save(student)).thenReturn(student);

        // When
        StudentResponse savedStudent = studentService.saveStudent(studentRequest);

        // Then
        Assertions.assertEquals("John", savedStudent.getName());
        Assertions.assertEquals(15, savedStudent.getAge());
        Mockito.verify(studentRepository, Mockito.times(1)).save(student);
    }
}
