package com.tech.service;

import com.tech.dto.UserRegisterDTO;
import com.tech.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
     AppUser registerUser(UserRegisterDTO userRegisterDTO) ;
}
