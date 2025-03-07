package com.example.ims_java.apiController;
import com.example.ims_java.entities.Employee;
import com.example.ims_java.services.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {

    private final EmployeeService service1;
    private final EmployeeService service2;

    public APIController(@Qualifier("employeeServiceImpl") EmployeeService service1,
                         @Qualifier("serviceImpl2") EmployeeService service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    @GetMapping("/api/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/api/employees")
    public List<Employee> getUsers() {
        return service1.getAllUsers();
    }

    @GetMapping("/api/employee")
    public ResponseEntity<?> getEmployeeByName(@RequestParam String name) {
        Optional<Employee> employee = service1.getEmployeeByUserName(name);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    @GetMapping("/api/employee/empid")
    public ResponseEntity<?> getEmployeeByEmployeeID(@RequestParam String empid) {
        Optional<Employee> employee = service1.getEmployeeByEmployeeID(empid);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    @GetMapping("/api/employee/list")
    public List<Employee> getEmployeeByList() {
        return service2.getAllUsers();
    }

    @PostMapping("/api/employee/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service2.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/api/employee/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee existingEmployee = service1.getEmployeeById(id);

        if (existingEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Set the new values for the existing employee
        existingEmployee.setEmployeeID(employee.getEmployeeID());
        existingEmployee.setUserName(employee.getUserName());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPassport(employee.getPassport());
        existingEmployee.setContactNO(employee.getContactNO());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setPostCode(employee.getPostCode());
        existingEmployee.setStatus(employee.getStatus());
        existingEmployee.setRoleID(employee.getRoleID());
        existingEmployee.setUpdateBy(employee.getUpdateBy());
        existingEmployee.setUpdateDate(employee.getUpdateDate());

        Employee updatedEmployee = service2.saveEmployee(existingEmployee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/api/employee/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Employee existingEmployee = service1.getEmployeeById(id);
        if (existingEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Delete the employee
        service1.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}