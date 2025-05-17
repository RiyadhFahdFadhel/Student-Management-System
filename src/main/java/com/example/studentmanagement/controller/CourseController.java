package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Course;
import com.example.studentmanagement.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return service.getCourseById(id).orElse(null);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
