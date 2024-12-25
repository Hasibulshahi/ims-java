package com.example.ims_java.services;

import com.example.ims_java.entities.Employee;
import com.example.ims_java.repositories.EmployeeRepository;
import com.example.ims_java.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeServiceImpl")
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee register(Employee user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Employee user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName())  ;
        } else {
            return "fail";
        }
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
