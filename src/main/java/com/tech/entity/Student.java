package com.tech.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@DiscriminatorValue("STUDENTS")
@RequiredArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person{


    @Column(name = "student_type")
    private StudentType studentType;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false) // This column will hold the foreign key
    private Set<Lesson> lessons;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName="id"),
            inverseJoinColumns =@JoinColumn(name = "teacher_id",referencedColumnName="id") )
    private Set<Teacher> teachers=new HashSet<>();;



}
