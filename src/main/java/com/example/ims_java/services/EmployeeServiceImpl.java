package com.example.ims_java.services;

import com.example.ims_java.entities.Employee;
import com.example.ims_java.repositories.EmployeeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeServiceImpl")
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByUserName(String name) {
        return employeeRepository.getByuserName(name);
    }

    @Override
    public Optional<Employee> getEmployeeByEmployeeID(String name) {
        return employeeRepository.getByemployeeID(name);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
