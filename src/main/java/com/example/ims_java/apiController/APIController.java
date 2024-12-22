package com.example.ims_java.apiController;
import com.example.ims_java.entities.Employee;
import com.example.ims_java.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {
    private final EmployeeService employeeService;

    public APIController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Define a GET endpoint
    @GetMapping("/api/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/api/employees")
    public List<Employee> getUsers() {
        return employeeService.getAllUsers();
    }

    @GetMapping("/api/employee")
    public ResponseEntity<?> getEmployeeByName(@RequestParam String name) {
        Optional<Employee> employee = employeeService.getEmployeeByusername(name);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }
}
