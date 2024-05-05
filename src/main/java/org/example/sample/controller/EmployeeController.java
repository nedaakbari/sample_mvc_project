package org.example.sample.controller;

import lombok.RequiredArgsConstructor;
import org.example.sample.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/register")
    public void registerEmployee(){

    }
}
