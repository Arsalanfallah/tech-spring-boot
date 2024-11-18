package com.tech.repository;

import com.tech.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    @Query("SELECT u FROM AppUser u WHERE u.status = ?1 and u.username = ?2")
    AppUser findUserByStatusAndName(Integer status, String name);
}
