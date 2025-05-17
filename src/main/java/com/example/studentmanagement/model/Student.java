package com.example.studentmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    // Many students belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // A student can take many subjects, and each subject can be taken by many students
    @ManyToMany
    @JoinTable(
        name = "student_subjects",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    // === Constructors ===
    public Student() {}

    public Student(String name, String email, Course course, List<Subject> subjects) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.subjects = subjects;
    }

    // === Getters and Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public List<Subject> getSubjects() { return subjects; }
    public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
}
