package com.example.ims_java.services;
import com.example.ims_java.entities.Menu;
import com.example.ims_java.repositories.MenuRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("menuServiceImpl")
@Primary
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getMenuByMenuName(String menuName) {
        return menuRepository.getByMenuName(menuName);
    }

    @Override
    public Optional<Menu> getMenuByMenuID(String menuId) {
        return menuRepository.getByMenuID(menuId);
    }

    @Override
    public Menu addMenu(Menu menu) {
        return this.menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
