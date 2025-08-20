package com.cibertec.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cibertec.security.entity.TipoPedido;
import com.cibertec.security.service.TipoPedidoService;

@RestController
@RequestMapping("/api/tipo_pedidos")
public class TipoPedidoController {

    private final TipoPedidoService service;

    public TipoPedidoController(TipoPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoPedido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TipoPedido obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public TipoPedido registrar(@RequestBody TipoPedido tipoPedido) {
        return service.registrar(tipoPedido);
    }

    @PutMapping("/{id}")
    public TipoPedido actualizar(@PathVariable Integer id, @RequestBody TipoPedido tipoPedido) {
        tipoPedido.setIdTipoPedido(id);
        return service.actualizar(tipoPedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
