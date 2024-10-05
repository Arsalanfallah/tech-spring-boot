package com.tech.service;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Lesson;
import com.tech.entity.Student;
import com.tech.entity.StudentType;
import com.tech.mapper.StudentMapper;
import com.tech.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
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
        Set<Lesson> lessonSet=Set.of(new Lesson(null,"Math","MATH"));
        Student student = new Student(null,"John", 16, "1234567891", StudentType.NORMAL,lessonSet);
        StudentRequest studentRequest=mapper.entityToRequest(student);
        // Mocking repository behavior
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        // When
        StudentResponse savedStudent = studentService.saveStudent(studentRequest);

        // Then
        assertNotNull(savedStudent, "Saved student should not be null");
        Assertions.assertEquals("John", savedStudent.getName());
        Assertions.assertEquals(16, savedStudent.getAge());
        // Verifying the repository save method was called
        Mockito.verify(studentRepository, Mockito.times(1)).save(any(Student.class));

    }
}
