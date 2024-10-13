package com.tech.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "lessons")
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Lesson extends AbstractEntity {

    @Column(name = "name_book")
    private String name;
    @Column(name = "code_book")
    private String code;


}
