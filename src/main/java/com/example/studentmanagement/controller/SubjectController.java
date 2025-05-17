package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Subject> getAll() {
        return service.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return service.getSubjectById(id).orElse(null);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject subject) {
        return service.updateSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSubject(id);
    }
}
