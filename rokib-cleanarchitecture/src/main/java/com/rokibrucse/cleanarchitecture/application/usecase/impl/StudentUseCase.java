package com.rokibrucse.cleanarchitecture.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.IStudentRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.IStudentUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentUseCase implements IStudentUseCase {

    @Autowired
    private IStudentRepository studentRepo;

    public List<Student> studentList() {
        return (List<Student>) studentRepo.findAll();
    }

    public List<Student> studentListByClassroomId(int id) {
        return (List<Student>) studentRepo.findByClassroomIdEquals(id);
    }

    public Optional<Student> coursesListByStudentId(int id) {
        return studentRepo.findById(id);
    }
}
