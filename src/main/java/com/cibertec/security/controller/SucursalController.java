package com.cibertec.security.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.security.entity.Sucursal;
import com.cibertec.security.service.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
	  @Autowired
	    private SucursalService sucursalService;

	    @GetMapping
	    public List<Sucursal> listar() {
	        return sucursalService.listar();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Sucursal> obtenerPorId(@PathVariable Integer id) {
	        Optional<Sucursal> sucursal = sucursalService.obtenerPorId(id);
	        return sucursal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Sucursal registrar(@RequestBody Sucursal sucursal) {
	        return sucursalService.registrar(sucursal);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
	        if (sucursalService.obtenerPorId(id).isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        sucursal.setId(id);
	        return ResponseEntity.ok(sucursalService.actualizar(sucursal));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
	        if (sucursalService.obtenerPorId(id).isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        sucursalService.eliminar(id);
	        return ResponseEntity.noContent().build();
	    }
	}