package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.service.SubjectService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return service.getAllSubjects();
    }

   @GetMapping("/{id}")
public ResponseEntity<Subject> getById(@PathVariable Long id) {
    return service.getSubjectById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<Subject> update(@PathVariable Long id, @RequestBody Subject updatedSubject) {
    return service.getSubjectById(id)
        .map(existing -> {
            existing.setTitle(updatedSubject.getTitle());
            existing.setTeacher(updatedSubject.getTeacher());
            return ResponseEntity.ok(service.createSubject(existing));
        })
        .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    service.deleteSubject(id);
}

}
