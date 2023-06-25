package com.spring.crud.controller.teacher;

import com.spring.crud.model.teacher.Teacher;
import com.spring.crud.model.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepo;

    public List<Teacher> teacherList(){
        return (List<Teacher>) teacherRepo.findAll();
    }
}
