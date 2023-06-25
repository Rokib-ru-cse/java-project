package com.rokibrucse.cleanarchitecture.presentation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rokibrucse.cleanarchitecture.application.usecase.ICourseUseCase;


public class CourseController {

    @Autowired
    private ICourseUseCase useCase;

    @GetMapping("/courses")
    public String courseList(Model model){
        model.addAttribute("courses",useCase.courseList());
        return "course/index";
    }

    @GetMapping("courses/students/{id}")
    public String courseStudentList(@PathVariable("id")int id,Model model){
    model.addAttribute("course",useCase.courseListStudent(id).get());
    return "course/course_student";
    }
}
