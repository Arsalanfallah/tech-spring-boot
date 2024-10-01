package com.tech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
