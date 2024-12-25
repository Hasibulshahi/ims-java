package com.example.ims_java.services;

import com.example.ims_java.entities.Employee;
import com.example.ims_java.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("serviceImpl2")
public class ServiceImpl2 implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public ServiceImpl2(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllUsers() {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setEmployeeID("E001");
        emp1.setUserName("jdoe");
        emp1.setPassword("password123");
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setPassport("A12345678");
        emp1.setContactNO("1234567890");
        emp1.setEmail("jdoe@example.com");
        emp1.setAddress("123 Main St, Anytown");
        emp1.setPostCode("12345");
        emp1.setStatus(1);
        emp1.setRoleID(2);
        emp1.setCreateBy("admin");

        Employee emp2 = new Employee();
        emp2.setEmployeeID("E002");
        emp2.setUserName("asmith");
        emp2.setPassword("password456");
        emp2.setFirstName("Alice");
        emp2.setLastName("Smith");
        emp2.setPassport("B98765432");
        emp2.setContactNO("9876543210");
        emp2.setEmail("asmith@example.com");
        emp2.setAddress("456 Elm St, Othertown");
        emp2.setPostCode("67890");
        emp2.setStatus(1);
        emp2.setRoleID(3);
        emp2.setCreateBy("manager");

        employees.add(emp1);
        employees.add(emp2);
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeByUserName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> getEmployeeByEmployeeID(String name) {
        return Optional.empty();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // Add business logic if needed, e.g., validation
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    }
}
