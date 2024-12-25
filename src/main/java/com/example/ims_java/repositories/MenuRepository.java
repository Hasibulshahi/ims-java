package com.example.ims_java.repositories;
import com.example.ims_java.entities.Employee;
import com.example.ims_java.entities.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> getByMenuName(String menuName);
    Optional<Menu> getByMenuID(String id);
}
