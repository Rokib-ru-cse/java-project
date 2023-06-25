package com.rokibrucse.cleanarchitecture.application.usecase;

import org.springframework.stereotype.Component;

import com.rokibrucse.cleanarchitecture.domain.entities.Student;

import java.util.List;
import java.util.Optional;

@Component
public interface IStudentUseCase {
    public List<Student> studentList();

    public List<Student> studentListByClassroomId(int id);

    public Optional<Student> coursesListByStudentId(int id);
}
