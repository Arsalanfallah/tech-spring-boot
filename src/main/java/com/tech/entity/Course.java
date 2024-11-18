package com.tech.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@Entity
@Table(name = "Course")
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Course extends AbstractEntity {

    @Column(name = "name_book")
    private String name;
    @Column(name = "code_book")
    private String code;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

}
