package com.tech.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app-user")
@Data
@AllArgsConstructor // Generates a constructor for all fields, necessary for @Builder
@NoArgsConstructor  // Required for JPA
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "status", nullable = true)
    private Integer status;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + username+
                ", passwordHash='" + passwordHash.substring(0, 10) +
                ", role=" + role +
                '}';
    }
}