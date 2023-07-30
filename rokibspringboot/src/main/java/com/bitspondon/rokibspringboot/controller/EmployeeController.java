package com.bitspondon.rokibspringboot.controller;

import com.bitspondon.rokibspringboot.entity.Employee;
import com.bitspondon.rokibspringboot.pizza.Pizza;
import com.bitspondon.rokibspringboot.pizza.VegPizza;
import com.bitspondon.rokibspringboot.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
@EnableCaching
public class EmployeeController {

    private final Pizza pizza;

    private final EmployeeService service;

    public EmployeeController(@Qualifier("vegPizza") Pizza pizza, EmployeeService service) {
        this.pizza = pizza;
        this.service = service;
    }

    @GetMapping
//    @Cacheable("products",)
    public ResponseEntity<List<Employee>> employees(){
        return  service.getEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployees(@Valid @RequestBody Employee employee){
        return  service.saveEmployee(employee);
    }

}
