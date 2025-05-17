package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Tells Spring this class will handle HTTP requests
@RequestMapping("/api/students")  // Base URL
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET all students: /api/students
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // GET student by ID: /api/students/1
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id).orElse(null);
    }

    // POST: Create new student
    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // PUT: Update student
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
