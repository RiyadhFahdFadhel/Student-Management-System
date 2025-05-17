package com.example.studentmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Many subjects to one teacher
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // Many students take many subjects
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    public Subject() {}
    public Subject(String title) { this.title = title; }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Teacher getTeacher() { return teacher; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
}
