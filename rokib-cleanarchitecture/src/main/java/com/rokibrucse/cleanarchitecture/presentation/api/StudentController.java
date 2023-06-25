package com.rokibrucse.cleanarchitecture.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/students")
    public String studentList() {
        return "";
    }

    @GetMapping("/students/classrooms/{id}")
    public String studentsByRoomId(@PathVariable(value = "id") int id) {
        return "";
    }

    @GetMapping("/students/courses/{id}")
    public String coursesByStudentId(@PathVariable(value = "id") int id) {
        return "";
    }
}
