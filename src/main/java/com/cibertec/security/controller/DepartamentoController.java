package com.cibertec.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cibertec.security.entity.Departamento;
import com.cibertec.security.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.listarTodo();
    }

    @GetMapping("/{id}")
    public Departamento obtenerPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Departamento registrar(@RequestBody Departamento departamento) {
        return service.registrar(departamento);
    }

    @PutMapping("/{id}")
    public Departamento actualizar(@PathVariable Integer id, @RequestBody Departamento departamento) {
        departamento.setId(id);
        return service.actualizar(departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
