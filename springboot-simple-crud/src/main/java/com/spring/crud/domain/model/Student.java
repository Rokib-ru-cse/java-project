package com.spring.crud.model.student;

import com.spring.crud.model.classroom.Classroom;
import com.spring.crud.model.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private Classroom classroom;

    @ManyToMany(mappedBy = "students") 
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String email, Classroom classroom, List<Course> courses) {
        this.name = name;
        this.email = email;
        this.classroom = classroom;
        this.courses = courses;
    }

    public Student(int id, String name, String email, Classroom classroom, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.classroom = classroom;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", classroom=" + classroom +
                ", courses=" + courses +
                '}';
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
