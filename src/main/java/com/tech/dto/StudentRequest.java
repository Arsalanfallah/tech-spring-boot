package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest implements Serializable {
    private final static long serialVersionUID = 3940954723216972217L;
    private String name;
    private Integer age;
}
