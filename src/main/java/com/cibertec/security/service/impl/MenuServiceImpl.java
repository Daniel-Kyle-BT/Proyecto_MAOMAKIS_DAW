
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Menu;
import com.cibertec.security.repository.MenuRepository;
import com.cibertec.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> listarMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> obtenerMenuPorId(Long idMenu) {
        return menuRepository.findById(idMenu);
    }

    @Override
    public Menu guardarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void eliminarMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

}
