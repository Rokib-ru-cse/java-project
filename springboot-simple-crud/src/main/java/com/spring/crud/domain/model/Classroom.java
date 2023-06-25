package com.spring.crud.model.classroom;

import com.spring.crud.model.student.Student;
import com.spring.crud.model.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int room_no;

    @OneToOne(mappedBy = "classroom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> student;

    public Classroom() {
    }

    public Classroom(int room_no, Teacher teacher, List<Student> student) {
        this.room_no = room_no;
        this.teacher = teacher;
        this.student = student;
    }

    public Classroom(int id, int room_no, Teacher teacher, List<Student> student) {
        this.id = id;
        this.room_no = room_no;
        this.teacher = teacher;
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
