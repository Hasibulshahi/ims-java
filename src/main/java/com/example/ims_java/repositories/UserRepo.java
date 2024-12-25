package com.example.ims_java.repositories;

import com.example.ims_java.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Employee, Integer> {
    Employee findByUserName(String username);
}
