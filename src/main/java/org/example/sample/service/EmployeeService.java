package org.example.sample.service;

import lombok.RequiredArgsConstructor;
import org.example.sample.model.Employee;
import org.example.sample.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {
    //The userDetailsService() method (like jdbcAuthentication(), ldapAuthentication, and inMemoryAuthentication()) configures a configuration store
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var employee = employeeRepository.findByUsername(username);
        if (employee.isPresent()) {
            var authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            var presentEmployee = employee.get();

            return new User(presentEmployee.getUsername(), presentEmployee.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}