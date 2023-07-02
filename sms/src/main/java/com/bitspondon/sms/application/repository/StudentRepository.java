package com.bitspondon.sms.application.repository;

import com.bitspondon.sms.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
