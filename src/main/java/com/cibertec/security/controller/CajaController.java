
package com.cibertec.security.controller;

import com.cibertec.security.entity.Caja;
import com.cibertec.security.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    @GetMapping
    public ResponseEntity<List<Caja>> listarCajas() {
        return ResponseEntity.ok(cajaService.listarCajas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caja> obtenerCaja(@PathVariable Integer id) {
        return cajaService.obtenerCajaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Caja> crearCaja(@RequestBody Caja caja) {
        Caja nuevaCaja = cajaService.guardarCaja(caja);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCaja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caja> actualizarCaja(@PathVariable Integer id, @RequestBody Caja caja) {
        return cajaService.obtenerCajaPorId(id)
                .map(cajaExistente -> {
                    caja.setId(id);
                    Caja cajaActualizada = cajaService.guardarCaja(caja);
                    return ResponseEntity.ok(cajaActualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCaja(@PathVariable Integer id) {
        if (cajaService.obtenerCajaPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cajaService.eliminarCaja(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<Caja>> listarCajasPorSucursal(@PathVariable Integer idSucursal) {
        return ResponseEntity.ok(cajaService.listarCajasPorSucursal(idSucursal));
    }

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<List<Caja>> listarCajasPorEstado(@PathVariable Integer idEstado) {
        return ResponseEntity.ok(cajaService.listarCajasPorEstado(idEstado));
    }
}
