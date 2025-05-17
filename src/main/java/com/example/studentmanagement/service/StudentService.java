package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Tells Spring this is a "Service" component
public class StudentService {

    private final StudentRepository repo;

    // Constructor to connect service to repository
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get one student by ID
    public Optional<Student> getStudentById(Long id) {
        return repo.findById(id);
    }

    // Create a new student
    public Student createStudent(Student student) {
        return repo.save(student);
    }

    // Update student
    public Student updateStudent(Long id, Student newStudent) {
        return repo.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            student.setCourse(newStudent.getCourse());
            return repo.save(student);
        }).orElseGet(() -> {
            // If not found, create new one with the given ID
            newStudent.setId(id);
            return repo.save(newStudent);
        });
    }

    // Delete student
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public Page<Student> getAllStudentsPaged(Pageable pageable) {
    return repo.findAll(pageable);
}

public Page<Student> getStudentsByCourse(String courseName, Pageable pageable) {
    return repo.findByCourse_Name(courseName, pageable);
}

}
