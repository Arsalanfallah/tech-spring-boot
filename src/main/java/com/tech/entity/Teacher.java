package com.tech.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("TEACHERS")
@Data
@SuperBuilder
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends Person{

    @Column(name = "teacher_type")
    private TeacherType teacherType;
    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();
}
