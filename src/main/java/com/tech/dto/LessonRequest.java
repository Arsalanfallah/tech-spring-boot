package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LessonRequest implements Serializable {
    private final static long serialVersionUID = 3940954723216972216L;
    private String name;
    private String code;

}
