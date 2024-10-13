package com.tech.service;

import com.tech.dto.TeacherRequest;
import com.tech.dto.TeacherResponse;
import com.tech.exceptions.ResourceNotFoundException;

import java.util.List;

public interface TeacherService {

    TeacherResponse saveTeacher(TeacherRequest teacherRequest);
    List<TeacherResponse> fetchTeacherByName(String name) throws ResourceNotFoundException;

    List<TeacherResponse> fetchAllTeachers();

    String deleteTeacherById(Long id);

    TeacherResponse updateTeacher(Long id, TeacherRequest newTeacher);

}
