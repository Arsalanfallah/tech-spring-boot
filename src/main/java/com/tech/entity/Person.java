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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (id ^ (id >>> 32));
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Possesion [id=").append(id).append(", name=").append(name).append("]");
        return builder.toString();
    }

}
