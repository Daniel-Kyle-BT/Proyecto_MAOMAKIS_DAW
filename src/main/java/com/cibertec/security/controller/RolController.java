package com.cibertec.security.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.security.entity.Rol;
import com.cibertec.security.service.RolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listar() {
        return rolService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Integer id) {
        return rolService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol registrar(@RequestBody Rol rol) {
        return rolService.registrar(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        return rolService.obtenerPorId(id).map(r -> {
            rol.setId(id);
            return ResponseEntity.ok(rolService.actualizar(rol));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (rolService.obtenerPorId(id).isPresent()) {
            rolService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
