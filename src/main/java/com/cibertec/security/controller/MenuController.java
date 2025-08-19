
package com.cibertec.security.controller;

import com.cibertec.security.entity.Menu;
import com.cibertec.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<Menu>> listarMenus() {
        return ResponseEntity.ok(menuService.listarMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> obtenerMenu(@PathVariable Long id) {
        return menuService.obtenerMenuPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Menu> crearMenu(@RequestBody Menu menu) {
        Menu nuevoMenu = menuService.guardarMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> actualizarMenu(@PathVariable Long id, @RequestBody Menu menu) {
        return menuService.obtenerMenuPorId(id)
                .map(menuExistente -> {
                    menu.setId(id);
                    Menu menuActualizado = menuService.guardarMenu(menu);
                    return ResponseEntity.ok(menuActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMenu(@PathVariable Long id) {
        if (menuService.obtenerMenuPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        menuService.eliminarMenu(id);
        return ResponseEntity.noContent().build();
    }
}
