package com.spring.crud.controller.classroom;

import com.spring.crud.model.classroom.Classroom;
import com.spring.crud.model.classroom.ClassroomRepository;
import com.spring.crud.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    private ClassroomRepository classroomRepo;

    public List<Classroom> classroomList() {
        return (List<Classroom>) classroomRepo.findAll();
    }

}
