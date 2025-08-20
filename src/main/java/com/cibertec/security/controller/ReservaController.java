
package com.cibertec.security.controller;

import com.cibertec.security.entity.Reserva;
import com.cibertec.security.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodos() {
        return ResponseEntity.ok(reservaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Reserva> guardar(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.guardar(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Reserva>> buscarReservasFiltro(
            @RequestParam(required = false, defaultValue = "0") Long idCliente,
            @RequestParam(required = false, defaultValue = "0") Long idEstado,
            @RequestParam(required = false, defaultValue = "0") Long idMesa,
            @RequestParam(required = false) LocalDate fechaReserva) {
        return ResponseEntity.ok(reservaService.buscarReservasFiltro(idCliente, idEstado, idMesa, fechaReserva));
    }
}
