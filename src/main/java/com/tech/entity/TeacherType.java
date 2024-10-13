package com.tech.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TeacherType {
    NORMAL,
    SPECIAL;
    @JsonCreator
    public static TeacherType fromValue(String value) {
        return TeacherType.valueOf(value.toUpperCase());
    }
}
