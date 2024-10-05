package com.tech.mapper;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source ="lessons" ,target ="lessonRequests" )
    StudentRequest entityToRequest(Student source);
    @Mapping(source ="lessonRequests" ,target ="lessons" )
    Student requestToEntity(StudentRequest source);
    @Mapping(source ="lessons" ,target ="lessonResponses" )
    StudentResponse entityToResponse(Student source);
    @Mapping(source ="lessons" ,target ="lessonResponses" )
    List<StudentResponse> listEntityToResponses(List<Student> sourceStudents);

}
