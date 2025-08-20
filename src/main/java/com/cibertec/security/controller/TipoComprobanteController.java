
package com.cibertec.security.controller;

import com.cibertec.security.entity.TipoComprobante;
import com.cibertec.security.service.TipoComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-comprobantes")
public class TipoComprobanteController {

    @Autowired
    private TipoComprobanteService tipoComprobanteService;

    @GetMapping
    public ResponseEntity<List<TipoComprobante>> listarTodos() {
        return ResponseEntity.ok(tipoComprobanteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoComprobante> buscarPorId(@PathVariable Long id) {
        TipoComprobante tipoComprobante = tipoComprobanteService.buscarPorId(id);
        return tipoComprobante != null ? ResponseEntity.ok(tipoComprobante) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoComprobante> guardar(@RequestBody TipoComprobante tipoComprobante) {
        return ResponseEntity.ok(tipoComprobanteService.guardar(tipoComprobante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoComprobanteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
