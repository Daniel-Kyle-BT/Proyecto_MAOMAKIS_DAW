package com.cibertec.security.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.security.entity.Mesa;
import com.cibertec.security.service.MesaService;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

	private final MesaService mesaService;

	public MesaController(MesaService mesaService) {
		this.mesaService = mesaService;
	}

	// 🔹 Listar todas las mesas
	// 🔹 con filtros opcionales
	@GetMapping()
	public List<Mesa> buscarMesas(@RequestParam(required = false, defaultValue = "0") Integer idSucursal,
			@RequestParam(required = false, defaultValue = "0") Integer idEstado,
			@RequestParam(required = false, defaultValue = "0") Integer numeroMesa) {
		return mesaService.buscarMesas(idSucursal, idEstado, numeroMesa);
	}

	// 🔹 Obtener mesa por ID
	@GetMapping("/{id}")
	public ResponseEntity<Mesa> obtenerMesaPorId(@PathVariable Long id) {
		return mesaService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// 🔹 Registrar mesa
	@PostMapping
	public ResponseEntity<Mesa> registrar(@RequestBody Mesa mesa) {
		Mesa nuevo = mesaService.guardarMesa(mesa);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
	}

	// 🔹 Actualizar mesa
	@PutMapping("/{id}")
	public ResponseEntity<Mesa> actualizar(@PathVariable Long id, @RequestBody Mesa mesa) {
		return mesaService.buscarPorId(id)
		.map(existente -> {
			mesa.setId(id);
			Mesa actualizado = mesaService.guardarMesa(mesa);
			return ResponseEntity.ok(actualizado);
		}).orElse(ResponseEntity.notFound().build());
	}

	// 🔹 Eliminar mesa
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		mesaService.eliminar(id);
	}

	@PatchMapping("/{id}/estado")
	public ResponseEntity<Void> cambiarEstadoMesa(@PathVariable Long id, @RequestParam Integer idEstado) {
		if (mesaService.buscarPorId(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		mesaService.cambiarEstado(id, idEstado);
		return ResponseEntity.noContent().build();
	}

}
