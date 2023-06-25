package com.spring.crud.controller.course;

import com.spring.crud.model.course.Course;
import com.spring.crud.model.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class CourseService {
    public List<Course> courseList();

    public Optional<Course> courseListStudent(int id);
}
