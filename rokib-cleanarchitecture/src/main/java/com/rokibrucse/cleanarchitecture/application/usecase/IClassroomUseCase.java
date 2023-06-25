package com.rokibrucse.cleanarchitecture.application.usecase;

import org.springframework.stereotype.Component;

import com.rokibrucse.cleanarchitecture.domain.entities.Classroom;

import java.util.List;

@Component
public interface IClassroomUseCase {
    public List<Classroom> classroomList();

}
