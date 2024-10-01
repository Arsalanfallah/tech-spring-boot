package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse implements Serializable {
    private final static long serialVersionUID = 3940954723216972218L;
    private Integer id;
    private String name;
    private Integer age;
}
