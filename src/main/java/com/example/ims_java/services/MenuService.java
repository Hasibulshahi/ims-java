package com.example.ims_java.services;
import com.example.ims_java.entities.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    public List<Menu> getAllMenu();
    public Optional<Menu> getMenuByMenuName(String menuName);
    public Optional<Menu> getMenuByMenuID(String menuId);
    public Menu addMenu(Menu menu);
    public Menu getMenuById(Long id);
    public void deleteMenu(Long id);
}
