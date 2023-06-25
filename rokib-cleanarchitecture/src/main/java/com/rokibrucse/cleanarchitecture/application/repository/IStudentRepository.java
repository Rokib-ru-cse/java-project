package com.rokibrucse.cleanarchitecture.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.rokibrucse.cleanarchitecture.domain.entities.Student;

import java.util.List;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByClassroomIdEquals(int id);
}
