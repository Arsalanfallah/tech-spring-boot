package com.tech.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lesson {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_seq_gen")
    @SequenceGenerator(name = "lesson_seq_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name_book")
    private String name;
    @Column(name = "code_book")
    private String code;


}
