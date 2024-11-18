package com.tech.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@Table(name = "course_rating")
@RequiredArgsConstructor
public class CourseRating {
    @EmbeddedId
    private CourseRatingKey id;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "rating")
    private int rating;
}
