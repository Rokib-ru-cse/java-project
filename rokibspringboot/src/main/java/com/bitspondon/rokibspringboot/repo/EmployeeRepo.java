package com.bitspondon.rokibspringboot.repo;

import com.bitspondon.rokibspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
