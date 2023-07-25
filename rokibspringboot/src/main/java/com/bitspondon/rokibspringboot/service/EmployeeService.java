package com.bitspondon.rokibspringboot.service;

import com.bitspondon.rokibspringboot.entity.Employee;
import com.bitspondon.rokibspringboot.repo.EmployeeRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Named
public class EmployeeService {

//    @Resource(name = "employeeRepo")
    @Inject
    private  EmployeeRepo employeeRepo;

//    public EmployeeService(EmployeeRepo employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }

    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return ResponseEntity.ok(employees);
    }

    //    @Transactional(propagation = Propagation.REQUIRED) //donot create new transaction, use parent transaction
//    @Transactional(propagation = Propagation.REQUIRES_NEW) //create new transaction
//    @Transactional(propagation = Propagation.NESTED) // this acts like required, but uses savepoints between nested invocation
//    @Transactional(propagation = Propagation.MANDATORY) // this required a parent level transaction
//    @Transactional(propagation = Propagation.NEVER) // cannot have parent level transaction
//    @Transactional(propagation = Propagation.NOT_SUPPORTED) // will not work parent level transaction.
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        Employee employee1 = employeeRepo.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct "+this.getClass().getName());
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("predestroy "+this.getClass().getName());
    }
}
