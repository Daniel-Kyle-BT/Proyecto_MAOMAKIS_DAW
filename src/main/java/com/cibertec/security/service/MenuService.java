
package com.cibertec.security.service;

import com.cibertec.security.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> listarMenus();
    Optional<Menu> obtenerMenuPorId(Long idMenu);
    Menu guardarMenu(Menu menu);
    void eliminarMenu(Long idMenu);
}
