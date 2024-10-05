package com.tech.repository;

import com.tech.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<List<Student>> findByName(String name);
    @Query("from Student e where e.name like :nameStudent")
    Optional<List<Student>> findLikeName(@Param("name") String nameStudent);
}
