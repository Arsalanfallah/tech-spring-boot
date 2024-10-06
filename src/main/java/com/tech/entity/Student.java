package com.tech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
/*
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
*/
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @NotBlank(message = "The content must not be null and must contain at least one non-whitespace character")
    @Size(min = 10, max = 10, message = "content must be at most 500 characters, and has at least one character")
    @Column(name = "national_Code")
    private String nationalCode;
    @Column(name = "student_type")
    private StudentType studentType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false) // This column will hold the foreign key
    private Set<Lesson> lessons;



}
