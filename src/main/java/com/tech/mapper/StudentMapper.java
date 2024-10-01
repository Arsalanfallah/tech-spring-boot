package com.tech.mapper;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentRequest entityToRequest(Student source);
    Student requestToEntity(StudentRequest source);
    StudentResponse entityToResponse(Student source);
    List<StudentResponse> listEntityToResponses(List<Student> sourceStudents);

}
