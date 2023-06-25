package com.spring.crud.model.teacher;

import com.spring.crud.model.classroom.Classroom;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional = false)
    private Classroom classroom;


    public Teacher() {
    }

    public Teacher(String name, Classroom classroom) {
        this.name = name;
        this.classroom = classroom;
    }

    public Teacher(int id, String name, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classroom=" + classroom +
                '}';
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
