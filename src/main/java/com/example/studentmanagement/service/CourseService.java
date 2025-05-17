package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Course;
import com.example.studentmanagement.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return repo.findById(id);
    }

    public Course createCourse(Course course) {
        return repo.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return repo.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            return repo.save(course);
        }).orElseGet(() -> {
            updatedCourse.setId(id);
            return repo.save(updatedCourse);
        });
    }

    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }
}
