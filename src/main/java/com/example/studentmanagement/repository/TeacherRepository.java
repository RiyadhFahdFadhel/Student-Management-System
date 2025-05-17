package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
