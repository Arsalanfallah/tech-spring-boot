package com.tech.controller;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/services/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Save Student message")
    @PostMapping(path = "saveStudent")
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse=studentService.saveStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }
    @Operation(summary = "Fetch specific student message")
    @GetMapping("/students/{name}")
    public ResponseEntity<List<StudentResponse>> fetchStudentByName(@NonNull @PathVariable("name") String name) {
        List<StudentResponse> studentResponses=studentService.fetchStudentByName(name);
        return new ResponseEntity<>(studentResponses, HttpStatus.OK);

    }
    @Operation(summary = "Fetch all of students message")
    @GetMapping("/students/fetchAllStudent")
    public ResponseEntity<List<StudentResponse>> fetchAllStudent() {
        List<StudentResponse> studentResponses=studentService.fetchAllStudents();
        return new ResponseEntity<>(studentResponses, HttpStatus.OK);

    }
    @Operation(summary = "Delete Student Message")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@NonNull @PathVariable("id") Integer id){
        return new ResponseEntity<>(studentService.deleteStudentById(id),HttpStatus.OK);
    }
}
