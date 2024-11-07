package com.tech.service.impl;

import com.tech.dto.UserDTO;
import com.tech.dto.UserRegisterDTO;
import com.tech.entity.AppUser;
import com.tech.repository.UserRepository;
import com.tech.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPasswordHash())
                        .roles(user.getRole().name()) // Set roles based on the user's role
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public AppUser registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        AppUser newUser =  AppUser.builder().username(userRegisterDTO.getUsername()).
                passwordHash(passwordEncoder.encode(userRegisterDTO.getPassword())).
                role(userRegisterDTO.getRole()).build();

        return userRepository.save(newUser);
    }
}

