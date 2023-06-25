package com.spring.crud.controller.classroom;

import com.spring.crud.model.classroom.Classroom;
import com.spring.crud.model.classroom.ClassroomRepository;
import com.spring.crud.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ClassroomService {
    public List<Classroom> classroomList();

}
