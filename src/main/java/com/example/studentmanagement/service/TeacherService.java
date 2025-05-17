package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Teacher;
import com.example.studentmanagement.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> getAllTeachers() {
        return repo.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return repo.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return repo.findById(id).map(teacher -> {
            teacher.setName(updatedTeacher.getName());
            return repo.save(teacher);
        }).orElseGet(() -> {
            updatedTeacher.setId(id);
            return repo.save(updatedTeacher);
        });
    }

    public void deleteTeacher(Long id) {
        repo.deleteById(id);
    }
}
