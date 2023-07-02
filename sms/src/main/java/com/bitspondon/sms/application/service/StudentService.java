package com.bitspondon.sms.application.service;

import com.bitspondon.sms.application.repository.StudentRepository;
import com.bitspondon.sms.domain.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
