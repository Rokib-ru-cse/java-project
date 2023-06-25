package com.spring.crud.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.studentList());
        return "student/index";
    }

    @GetMapping("/students/classrooms/{id}")
    public String studentsByRoomId(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("students", studentService.studentListByClassroomId(id));
        return "student/student_class";
    }

    @GetMapping("/students/courses/{id}")
    public String coursesByStudentId(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("student", studentService.coursesListByStudentId(id).get());
        return "student/student_courses";
    }
}
