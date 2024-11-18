package com.tech.configuration;

import com.tech.entity.Role;
import com.tech.entity.AppUser;
import com.tech.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            AppUser user = new AppUser();
            user.setUsername("user");
            user.setPasswordHash(passwordEncoder.encode("password"));
            user.setRole(Role.USER);
            user.setStatus(1);
            repository.save(user);

            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPasswordHash(passwordEncoder.encode("admin"));
            admin.setRole(Role.ADMIN);
            user.setStatus(1);
            repository.save(admin);
        };
    }
}
