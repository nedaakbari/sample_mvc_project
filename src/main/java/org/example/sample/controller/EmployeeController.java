package org.example.sample.controller;

import lombok.RequiredArgsConstructor;
import org.example.sample.model.Users;
import org.example.sample.repository.EmployeeRepository;
import org.example.sample.service.EmployeeService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/register")
    public void registerEmployee() {
        employeeService.register();
    }
}
