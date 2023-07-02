package com.bitspondon.sms.presentation.web.controller;

import com.bitspondon.sms.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/")
    public String students(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }
    @GetMapping("/students")
    public String studentList(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

}
