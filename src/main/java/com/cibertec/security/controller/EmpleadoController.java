package com.cibertec.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cibertec.security.entity.Empleado;
import com.cibertec.security.service.EmpleadoService;


@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {


    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados(
            @RequestParam(defaultValue = "true") boolean estado,
            @RequestParam(defaultValue = "0") int idCargo,
            @RequestParam(defaultValue = "0") int idDistrito,
            @RequestParam(defaultValue = "0") int idProvincia,
            @RequestParam(defaultValue = "0") int idDepartamento) {

        List<Empleado> empleados = empleadoService.listarEmpleadoPorFiltros(
                estado, idCargo, idDistrito, idProvincia, idDepartamento
        );
        return ResponseEntity.ok(empleados);
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevo = empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.obtenerEmpleadoPorId(id)
                .map(existente -> {
                    empleado.setId(id);
                    Empleado actualizado = empleadoService.guardarEmpleado(empleado);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        if (empleadoService.obtenerEmpleadoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstadoEmpleado(@PathVariable Long id, @RequestParam boolean nuevoEstado) {
        if (empleadoService.obtenerEmpleadoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        empleadoService.cambiarEstadoEmpleado(id, nuevoEstado);
        return ResponseEntity.noContent().build();
    }
}