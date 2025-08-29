package com.cibertec.security.controller;

import com.cibertec.security.entity.DetallePedido;
import com.cibertec.security.entity.DetallePedidoId;
import com.cibertec.security.repository.DetallePedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalle-pedido")
public class DetallePedidoController {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoController(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    // 🔹 Listar detalles por pedido
    @GetMapping("/{idPedido}")
    public ResponseEntity<List<DetallePedido>> listarPorPedido(@PathVariable Long idPedido) {
        List<DetallePedido> detalles = detallePedidoRepository.findByPedidoId(idPedido);
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    // 🔹 Buscar un detalle puntual (por su id compuesto)
    @GetMapping("/buscar")
    public ResponseEntity<DetallePedido> obtenerDetalle(@RequestBody DetallePedidoId id) {
        Optional<DetallePedido> detalle = detallePedidoRepository.findById(id);
        return detalle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Crear nuevo detalle
    @PostMapping
    public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido detalle) {
        DetallePedido guardado = detallePedidoRepository.save(detalle);
        return ResponseEntity.ok(guardado);
    }

    // 🔹 Actualizar un detalle existente
    @PutMapping
    public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido detalle) {
        if (!detallePedidoRepository.existsById(detalle.getId())) {
            return ResponseEntity.notFound().build();
        }
        DetallePedido actualizado = detallePedidoRepository.save(detalle);
        return ResponseEntity.ok(actualizado);
    }

    // 🔹 Eliminar detalle
    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestBody DetallePedidoId id) {
        if (!detallePedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detallePedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}