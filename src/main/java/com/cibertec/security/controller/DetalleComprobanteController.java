package com.cibertec.security.controller;

import com.cibertec.security.entity.DetalleComprobante;
import com.cibertec.security.repository.DetalleComprobanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle-comprobante")
public class DetalleComprobanteController {

    private final DetalleComprobanteRepository detalleComprobanteRepository;

    public DetalleComprobanteController(DetalleComprobanteRepository detalleComprobanteRepository) {
        this.detalleComprobanteRepository = detalleComprobanteRepository;
    }

    // 🔹 Listar detalles por comprobante
    @GetMapping("/{idComprobante}")
    public ResponseEntity<List<DetalleComprobante>> listarPorComprobante(@PathVariable Long idComprobante) {
        List<DetalleComprobante> detalles = detalleComprobanteRepository.findByComprobanteId(idComprobante);
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    // 🔹 Buscar un detalle por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<DetalleComprobante> obtenerDetalle(@PathVariable Long id) {
        Optional<DetalleComprobante> detalle = detalleComprobanteRepository.findById(id);
        return detalle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Crear nuevo detalle
    @PostMapping
    public ResponseEntity<DetalleComprobante> crear(@RequestBody DetalleComprobante detalle) {
        DetalleComprobante guardado = detalleComprobanteRepository.save(detalle);
        return ResponseEntity.ok(guardado);
    }

    // 🔹 Actualizar detalle existente
    @PutMapping("/{id}")
    public ResponseEntity<DetalleComprobante> actualizar(@PathVariable Long id, @RequestBody DetalleComprobante detalle) {
        if (!detalleComprobanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detalle.setIdDetalleComprobante(id);
        DetalleComprobante actualizado = detalleComprobanteRepository.save(detalle);
        return ResponseEntity.ok(actualizado);
    }

    // 🔹 Eliminar detalle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!detalleComprobanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detalleComprobanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
