package com.tech.mapper;

import com.tech.dto.TeacherRequest;
import com.tech.dto.TeacherResponse;
import com.tech.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(source ="students" ,target ="studentRequests" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    TeacherRequest entityToRequest(Teacher source);
    @Mapping(source ="studentRequests" ,target ="students" )
    @Mapping(target = "birthDate", expression = "java(mapStringToDate(source.getBirthDate()))")
    Teacher requestToEntity(TeacherRequest source)throws ParseException;;
    @Mapping(source ="students" ,target ="studentResponses" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    TeacherResponse entityToResponse(Teacher source);
    @Mapping(source ="students" ,target ="studentResponses" )
    @Mapping(source = "birthDate", target ="birthDate", dateFormat = "yyyy-MM-dd")
    List<TeacherResponse> listEntityToResponses(List<Teacher> sourceTeachers);
    default Date mapStringToDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("date:::"+date);
        return dateFormat.parse(date);
    }
}
