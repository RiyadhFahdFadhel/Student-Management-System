package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Teacher;
import com.example.studentmanagement.service.TeacherService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getAll() {
        return service.getAllTeachers();
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return service.createTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTeacher(id);
    }

    @GetMapping("/{id}")
public ResponseEntity<Teacher> getById(@PathVariable Long id) {
    return service.getTeacherById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
    return service.getTeacherById(id)
        .map(existingTeacher -> {
            existingTeacher.setName(updatedTeacher.getName());
            return ResponseEntity.ok(service.createTeacher(existingTeacher)); // save & return updated
        })
        .orElse(ResponseEntity.notFound().build());
}


}
