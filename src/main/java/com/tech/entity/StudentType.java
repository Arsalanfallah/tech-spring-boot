package com.tech.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StudentType {
    NORMAL,
    SPECIAL;
    @JsonCreator
    public static StudentType fromValue(String value) {
        return StudentType.valueOf(value.toUpperCase());
    }
}
