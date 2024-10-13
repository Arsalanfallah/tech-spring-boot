package com.tech.mapper;

import com.tech.dto.StudentRequest;
import com.tech.dto.StudentResponse;
import com.tech.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source ="lessons" ,target ="lessonRequests" )
    @Mapping(source ="teachers" ,target ="teacherRequests" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    StudentRequest entityToRequest(Student source);
    @Mapping(source ="lessonRequests" ,target ="lessons" )
    @Mapping(source ="teacherRequests" ,target ="teachers" )
    @Mapping(target = "birthDate", expression = "java(mapStringToDate(source.getBirthDate()))")
    Student requestToEntity(StudentRequest source)throws java.text.ParseException;;
    @Mapping(source ="lessons" ,target ="lessonResponses" )
    @Mapping(source ="teachers" ,target ="teacherResponses" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    StudentResponse entityToResponse(Student source);
    @Mapping(source ="lessons" ,target ="lessonResponses" )
    @Mapping(source ="teachers" ,target ="teacherResponses" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    List<StudentResponse> listEntityToResponses(List<Student> sourceStudents);
    default Date mapStringToDate(String date) throws java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("date:::"+date);
        return dateFormat.parse(date);
    }
}
