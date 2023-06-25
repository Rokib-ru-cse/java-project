package com.spring.crud.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courseList(Model model){
        model.addAttribute("courses",courseService.courseList());
        return "course/index";
    }

    @GetMapping("courses/students/{id}")
    public String courseStudentList(@PathVariable("id")int id,Model model){
    model.addAttribute("course",courseService.courseListStudent(id).get());
    return "course/course_student";
    }
}
