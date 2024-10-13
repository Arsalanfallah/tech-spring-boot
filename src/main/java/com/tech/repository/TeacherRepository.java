package com.tech.repository;

import com.tech.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<List<Teacher>> findByName(String name);
    @Query("from Teacher e where e.name like :nameTeacher")
    Optional<List<Teacher>> findLikeName(@Param("name") String nameTeacher);
}
