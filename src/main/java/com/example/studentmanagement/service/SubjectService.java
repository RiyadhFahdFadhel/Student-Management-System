package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository repo;

    public SubjectService(SubjectRepository repo) {
        this.repo = repo;
    }

    public List<Subject> getAllSubjects() {
        return repo.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return repo.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return repo.save(subject);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        return repo.findById(id).map(subject -> {
            subject.setTitle(updatedSubject.getTitle());
            subject.setTeacher(updatedSubject.getTeacher());
            return repo.save(subject);
        }).orElseGet(() -> {
            updatedSubject.setId(id);
            return repo.save(updatedSubject);
        });
    }

    public void deleteSubject(Long id) {
        repo.deleteById(id);
    }
}
