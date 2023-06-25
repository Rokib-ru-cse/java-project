package com.rokibrucse.cleanarchitecture.application.usecase.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.IClassroomRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.IClassroomUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Classroom;

import java.util.List;

@Service
public class ClassroomUseCase implements IClassroomUseCase {

    @Autowired
    private IClassroomRepository classroomRepo;

    public List<Classroom> classroomList() {
        return (List<Classroom>) classroomRepo.findAll();
    }

}
