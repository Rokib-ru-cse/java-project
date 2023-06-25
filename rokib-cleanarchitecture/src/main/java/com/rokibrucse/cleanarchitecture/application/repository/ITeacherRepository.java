package com.rokibrucse.cleanarchitecture.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.rokibrucse.cleanarchitecture.domain.entities.Teacher;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {
}
