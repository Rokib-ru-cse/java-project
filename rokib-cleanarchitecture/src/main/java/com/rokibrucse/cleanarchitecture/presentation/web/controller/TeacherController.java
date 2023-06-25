package com.rokibrucse.cleanarchitecture.presentation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rokibrucse.cleanarchitecture.application.usecase.ITeacherUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Teacher;

import java.util.List;
public class TeacherController {
    @Autowired
    private ITeacherUseCase teacherService;
    @GetMapping("/teachers")
    public String teachers(Model model){
        List<Teacher> teacherList = teacherService.teacherList();
        model.addAttribute("teachers",teacherList);
        return "teacher/index";
    }
}
