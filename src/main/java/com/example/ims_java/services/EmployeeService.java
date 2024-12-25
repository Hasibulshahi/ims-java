package com.example.ims_java.services;

import com.example.ims_java.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllUsers();
    public Optional<Employee> getEmployeeByUserName(String name);
    public Optional<Employee> getEmployeeByEmployeeID(String name);
    public Employee saveEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public void deleteEmployee(Long id);
    public Employee register(Employee user);
    public String verify(Employee user);
}
