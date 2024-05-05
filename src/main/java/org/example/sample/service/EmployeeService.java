package org.example.sample.service;

import lombok.RequiredArgsConstructor;
import org.example.sample.model.Employee;
import org.example.sample.model.Users;
import org.example.sample.repository.EmployeeRepository;
import org.example.sample.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.FileNameMap;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public void register() {
        var users = new Users();
        users.setEnabled(true);
        users.setPassword(passwordEncoder.encode("123"));
        users.setUsername("neda");
        Users save = usersRepository.save(users);

        Employee employee = new Employee();
        employee.setUsers(save);
        employee.setEmployeeID("256");
        employee.setLastName("akbari");
        employee.setFirstName("neda");
        employee.setNationalCode("25602555");

        employeeRepository.save(employee);
    }
}
