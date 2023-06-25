package com.spring.crud.controller.teacher;

import com.spring.crud.model.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/teachers")
    public String teachers(Model model){
        List<Teacher> teacherList = teacherService.teacherList();
        model.addAttribute("teachers",teacherList);
        return "teacher/index";
    }
}
