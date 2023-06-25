package com.rokibrucse.cleanarchitecture.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.ICourseRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.ICourseUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Course;

import java.util.List;
import java.util.Optional;

@Service
public class CourseUseCase implements ICourseUseCase {
    @Autowired
    private ICourseRepository courseRepo;
    public List<Course> courseList(){
        return (List<Course>)courseRepo.findAll();
    }

    public Optional<Course> courseListStudent(int id){
        return (Optional<Course>) courseRepo.findById(id);
    }
}
