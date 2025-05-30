package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// StudentRepository is a special interface that can talk to the database
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByCourse_Name(String courseName, Pageable pageable);
}

