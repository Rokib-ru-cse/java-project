package com.spring.crud.controller.student;

import com.spring.crud.model.course.CourseRepository;
import com.spring.crud.model.student.Student;
import com.spring.crud.model.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;

    public List<Student> studentList() {
        return (List<Student>) studentRepo.findAll();
    }

    public List<Student> studentListByClassroomId(int id) {
        return (List<Student>) studentRepo.findByClassroomIdEquals(id);
    }
    public Optional<Student> coursesListByStudentId(int id) {
        return studentRepo.findById(id);
    }
}
