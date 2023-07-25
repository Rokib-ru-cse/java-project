package com.bitspondon.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {

    private final RestTemplate restTemplate;

    public EmployeeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/employees")
    public String employees() {
        String url = "http://EMPLOYEE-SERVICE/employe";
        return restTemplate.getForObject(url, String.class);
    }

}
