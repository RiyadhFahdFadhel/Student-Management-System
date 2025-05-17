
package com.example.studentmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Optional: one course can have many students
    @OneToMany(mappedBy = "course")
    private List<Student> students;

    public Course() {}
    public Course(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
