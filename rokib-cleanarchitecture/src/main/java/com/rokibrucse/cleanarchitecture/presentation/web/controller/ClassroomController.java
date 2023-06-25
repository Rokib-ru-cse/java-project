package com.rokibrucse.cleanarchitecture.presentation.web.controller;

import com.rokibrucse.cleanarchitecture.application.usecase.IClassroomUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ClassroomController {
    @Autowired
    private IClassroomUseCase useCase;

    @GetMapping("/classrooms")
    public String classroomList(Model model) {
        model.addAttribute("classrooms", (List<Classroom>) useCase.classroomList());
        return "classroom/index";
    }

}
