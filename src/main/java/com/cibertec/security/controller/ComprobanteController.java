
package com.cibertec.security.controller;

import com.cibertec.security.entity.Comprobante;
import com.cibertec.security.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping
    public ResponseEntity<List<Comprobante>> listarComprobantes() {
        return ResponseEntity.ok(comprobanteService.listarComprobantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comprobante> obtenerComprobante(@PathVariable Long id) {
        return comprobanteService.obtenerComprobantePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comprobante> crearComprobante(@RequestBody Comprobante comprobante) {
        Comprobante nuevoComprobante = comprobanteService.guardarComprobante(comprobante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComprobante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprobante> actualizarComprobante(@PathVariable Long id, @RequestBody Comprobante comprobante) {
        return comprobanteService.obtenerComprobantePorId(id)
                .map(existente -> {
                    comprobante.setIdComprobante(id);
                    Comprobante actualizado = comprobanteService.guardarComprobante(comprobante);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComprobante(@PathVariable Long id) {
        if (comprobanteService.obtenerComprobantePorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        comprobanteService.eliminarComprobante(id);
        return ResponseEntity.noContent().build();
    }

	@GetMapping("/filtro")
	public ResponseEntity<List<Comprobante>> buscarComprobantesFiltro(
	        @RequestParam(required = false, defaultValue = "0") Long idPedido,
	        @RequestParam(required = false, defaultValue = "0") Long idCliente,
	        @RequestParam(required = false, defaultValue = "0") Long idEmpleado,
	        @RequestParam(required = false, defaultValue = "0") Long idCaja,
	        @RequestParam(required = false, defaultValue = "0") Long idEstado,
	        @RequestParam(required = false) LocalDateTime fechaInicio,
	        @RequestParam(required = false) LocalDateTime fechaFin) {
	    return ResponseEntity.ok(comprobanteService.buscarComprobantesFiltro(idPedido, idCliente, idEmpleado, idCaja, idEstado, fechaInicio, fechaFin));
	}
}
