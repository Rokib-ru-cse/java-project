package com.spring.crud.controller.student;

import com.spring.crud.model.course.CourseRepository;
import com.spring.crud.model.student.Student;
import com.spring.crud.model.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    public List<Student> studentList() ;
    public List<Student> studentListByClassroomId(int id);
    public Optional<Student> coursesListByStudentId(int id) ;
}
