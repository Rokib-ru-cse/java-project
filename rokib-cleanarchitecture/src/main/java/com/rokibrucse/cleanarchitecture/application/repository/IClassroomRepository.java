package com.rokibrucse.cleanarchitecture.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.rokibrucse.cleanarchitecture.domain.entities.Classroom;

public interface IClassroomRepository extends CrudRepository<Classroom,Integer> {
}
