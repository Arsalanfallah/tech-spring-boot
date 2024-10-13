package com.tech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@SuperBuilder
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @NotBlank(message = "The content must not be null and must contain at least one non-whitespace character")
    @Pattern(regexp = "^\\d{10}$", message = "National code must be a 10-digit number")
    @Column(name = "national_Code")
    private String nationalCode;
    @Column(name = "birth_date" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;


}
