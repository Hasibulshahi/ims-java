package com.example.ims_java.repositories;

import com.example.ims_java.entities.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getByuserName(String name);
    Optional<Employee> getByemployeeID(String name);
}
