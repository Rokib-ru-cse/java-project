package com.spring.crud.controller.course;

import com.spring.crud.model.course.Course;
import com.spring.crud.model.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseRepository courseRepo;
    public List<Course> courseList(){
        return (List<Course>)courseRepo.findAll();
    }

    public Optional<Course> courseListStudent(int id){
        return (Optional<Course>) courseRepo.findById(id);
    }
}
