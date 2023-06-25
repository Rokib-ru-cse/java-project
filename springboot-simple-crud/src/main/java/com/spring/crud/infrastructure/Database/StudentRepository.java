package com.spring.crud.model.student;

import com.spring.crud.model.course.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByClassroomIdEquals(int id);
}
