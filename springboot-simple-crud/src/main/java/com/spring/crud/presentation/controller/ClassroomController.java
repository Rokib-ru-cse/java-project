package com.spring.crud.controller.classroom;

import com.spring.crud.model.classroom.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classrooms")
    public String classroomList(Model model) {
        model.addAttribute("classrooms",(List<Classroom>) classroomService.classroomList());
        return "classroom/index";
    }


}
