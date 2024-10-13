package com.tech.service.impl;

import com.tech.dto.TeacherRequest;
import com.tech.dto.TeacherResponse;
import com.tech.entity.Teacher;
import com.tech.exceptions.ResourceNotFoundException;
import com.tech.mapper.TeacherMapper;
import com.tech.repository.TeacherRepository;
import com.tech.service.TeacherService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    @Transactional
    @SneakyThrows
    public TeacherResponse saveTeacher(TeacherRequest studentRequest) {
        Teacher student = teacherMapper.requestToEntity(studentRequest);
        student = teacherRepository.save(student);
        return teacherMapper.entityToResponse(student);

    }

    @Override
    public List<TeacherResponse> fetchTeacherByName(String name) throws ResourceNotFoundException {
        List<TeacherResponse> studentResponses = new ArrayList<>();
        List<Teacher> studentList= teacherRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (studentList != null && !studentList.isEmpty()) {
            studentResponses = teacherMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }

    @Override
    public List<TeacherResponse> fetchAllTeachers() {
        List<TeacherResponse> studentResponses = new ArrayList<>();
        List<Teacher> studentList = teacherRepository.findAll();

        if (studentList != null && !studentList.isEmpty()) {
            studentResponses = teacherMapper.listEntityToResponses(studentList);
        }
        return studentResponses;
    }

    @Override
    public String deleteTeacherById(Long id) {
        log.info("Delete Client with ID ={} ", id);
        teacherRepository.deleteById(id);
        return String.format("Teacher with id {%d} is deleted", id);
    }

    @Override
    @Transactional()
    public TeacherResponse updateTeacher(Long id, TeacherRequest newTeacher) {
        log.info("Update Client with ID ={} ", id);
        TeacherResponse response = null;
        Optional<Teacher> studentOptional = teacherRepository.findById(id);

        if (studentOptional.isPresent()) {
            Teacher clt = studentOptional.get();
            clt.setName(newTeacher.getName());
            clt.setAge(newTeacher.getAge());
            clt.setNationalCode(newTeacher.getNationalCode());
            Teacher student = teacherRepository.save(clt);
            response=teacherMapper.entityToResponse(student);
        }

        return response;
    }
}
