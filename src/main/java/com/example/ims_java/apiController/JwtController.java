package com.example.ims_java.apiController;

import com.example.ims_java.entities.Employee;
import com.example.ims_java.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private final EmployeeService service;

    public JwtController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Employee register(@RequestBody Employee user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee user) {
        return service.verify(user);
    }
}
