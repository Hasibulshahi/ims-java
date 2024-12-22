package com.example.ims_java.services;

import com.example.ims_java.entities.Employee;
import com.example.ims_java.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeByusername(String name) {
        return employeeRepository.findByusername(name);
    }
}
