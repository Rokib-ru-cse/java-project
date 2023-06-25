package com.rokibrucse.cleanarchitecture.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.ITeacherRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.ITeacherUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Teacher;

import java.util.List;

@Service
public class TeacherUseCase implements ITeacherUseCase {
    @Autowired
    private ITeacherRepository teacherRepo;

    public List<Teacher> teacherList(){
        return (List<Teacher>) teacherRepo.findAll();
    }
}
