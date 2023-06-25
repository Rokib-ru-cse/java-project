package com.rokibrucse.cleanarchitecture.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClassroomController {

    @GetMapping("/classrooms")
    public String classroomList() {
        return "";
    }

}
