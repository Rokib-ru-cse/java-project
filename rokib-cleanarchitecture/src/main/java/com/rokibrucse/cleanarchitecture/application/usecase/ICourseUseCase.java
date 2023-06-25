package com.rokibrucse.cleanarchitecture.application.usecase;

import org.springframework.stereotype.Component;

import com.rokibrucse.cleanarchitecture.domain.entities.Course;

import java.util.List;
import java.util.Optional;

@Component
public interface ICourseUseCase {
    public List<Course> courseList();

    public Optional<Course> courseListStudent(int id);
}
