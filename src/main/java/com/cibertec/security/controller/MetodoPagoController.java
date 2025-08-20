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

import com.cibertec.security.entity.MetodoPago;
import com.cibertec.security.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodos_pago")
@CrossOrigin(origins = "*") // 🔹 Permite llamadas desde cualquier frontend
public class MetodoPagoController {


    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> listar() {
        return metodoPagoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerPorId(@PathVariable Integer id) {
        return metodoPagoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MetodoPago registrar(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.registrar(metodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizar(@PathVariable Integer id, @RequestBody MetodoPago metodoPago) {
        return metodoPagoService.obtenerPorId(id).map(m -> {
            metodoPago.setIdMetodoPago(id);
            return ResponseEntity.ok(metodoPagoService.actualizar(metodoPago));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (metodoPagoService.obtenerPorId(id).isPresent()) {
            metodoPagoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
