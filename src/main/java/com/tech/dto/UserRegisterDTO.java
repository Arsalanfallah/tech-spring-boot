package com.tech.dto;

import com.tech.entity.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRegisterDTO {
    private String username;
    private String password;
    private Role role;
}
