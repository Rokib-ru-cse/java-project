package com.rokibrucse.cleanarchitecture.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public String courseList() {
        return "";
    }

    @GetMapping("courses/students/{id}")
    public String courseStudentList(@PathVariable("id") int id) {
        return "";
    }
}
