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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_book")
    private String name;
    @Column(name = "code_book")
    private String code;


}
