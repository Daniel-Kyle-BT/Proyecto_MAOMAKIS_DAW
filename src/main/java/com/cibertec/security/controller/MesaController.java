package com.cibertec.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Mesa> listar() {
        return mesaService.lista();
    }

    // 🔹 Obtener mesa por ID
    @GetMapping("/{id}")
    public Mesa obtenerPorId(@PathVariable Long id) {
        return mesaService.buscarPorId(id);
    }

    // 🔹 Registrar mesa
    @PostMapping
    public Mesa registrar(@RequestBody Mesa mesa) {
        return mesaService.registrar(mesa);
    }

    // 🔹 Actualizar mesa
    @PutMapping("/{id}")
    public Mesa actualizar(@PathVariable Long id, @RequestBody Mesa mesa) {
        mesa.setId(id);
        return mesaService.actualizar(mesa);
    }

    // 🔹 Eliminar mesa
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mesaService.eliminar(id);
    }

    // 🔹 Nuevo endpoint con filtros opcionales
    @GetMapping("/buscar")
    public List<Mesa> buscarMesas(
            @RequestParam(required = false) Integer idSucursal,
            @RequestParam(required = false) Integer idEstado,
            @RequestParam(required = false) Integer numeroMesa
    ) {
        return mesaService.buscarMesas(idSucursal, idEstado, numeroMesa);
    }
}
