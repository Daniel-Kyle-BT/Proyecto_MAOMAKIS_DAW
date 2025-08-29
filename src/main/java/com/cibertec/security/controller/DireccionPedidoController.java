package com.cibertec.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cibertec.security.entity.DireccionPedido;
import com.cibertec.security.service.DireccionPedidoService;

@RestController
@RequestMapping("/api/direcciones_pedido")
public class DireccionPedidoController {

    private final DireccionPedidoService service;

    public DireccionPedidoController(DireccionPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DireccionPedido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DireccionPedido obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public DireccionPedido registrar(@RequestBody DireccionPedido direccionPedido) {
        return service.registrar(direccionPedido);
    }

    @PutMapping("/{id}")
    public DireccionPedido actualizar(@PathVariable Long id, @RequestBody DireccionPedido direccionPedido) {
        direccionPedido.setIdDireccion(id);
        return service.actualizar(direccionPedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
