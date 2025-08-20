
package com.cibertec.security.controller;

import com.cibertec.security.entity.Distrito;
import com.cibertec.security.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public ResponseEntity<List<Distrito>> listarTodos() {
        return ResponseEntity.ok(distritoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distrito> buscarPorId(@PathVariable Integer id) {
        Distrito distrito = distritoService.buscarPorId(id);
        return distrito != null ? ResponseEntity.ok(distrito) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Distrito> guardar(@RequestBody Distrito distrito) {
        return ResponseEntity.ok(distritoService.guardar(distrito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        distritoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Distrito>> buscarDistritosFiltro(
            @RequestParam(required = false, defaultValue = "0") Integer idProvincia,
            @RequestParam(required = false) String descripcion) {
        return ResponseEntity.ok(distritoService.buscarDistritosFiltro(idProvincia, descripcion));
    }
}
