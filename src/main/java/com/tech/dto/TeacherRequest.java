package com.tech.dto;

import com.tech.entity.StudentType;
import com.tech.entity.TeacherType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest implements Serializable {
    private final static long serialVersionUID = 3940954723216972211L;
    @NotBlank(message = "The name must not be null and must contain at least one non-whitespace character")
    private String name;
    @NotNull
    private Integer age;
    @NotBlank(message = "The nationalCode must not be null and must contain at least one non-whitespace character")
    //@Size(min = 10, max = 10, message = "nationalCode must be at most 500 characters, and has at least one character")
    @Pattern(regexp = "^\\d{10}$", message = "National code must be a 10-digit number")
    private String nationalCode;
    private String birthDate;
    private TeacherType teacherType;

    private Set<StudentRequest> studentRequests=null;
}
