package com.rokibrucse.cleanarchitecture.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @GetMapping("/teachers")
    public String teachers() {
        return "";
    }
}
