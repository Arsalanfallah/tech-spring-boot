package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LessonResponse implements Serializable {
    private final static long serialVersionUID = 3940954723216972215L;
    private String name;
    private String code;
    private Long id;

}
