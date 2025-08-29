
package com.cibertec.security.controller;

import com.cibertec.security.entity.Estado;
import com.cibertec.security.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listarTodos() {
        return ResponseEntity.ok(estadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id) {
        Estado estado = estadoService.buscarPorId(id);
        return estado != null ? ResponseEntity.ok(estado) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.guardar(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
