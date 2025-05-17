package com.example.studentmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One teacher teaches many subjects
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    public Teacher() {}
    public Teacher(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
