
package com.cibertec.security.controller;

import com.cibertec.security.entity.CargoEmpleado;
import com.cibertec.security.service.CargoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoEmpleadoController {

    @Autowired
    private CargoEmpleadoService cargoEmpleadoService;

    @GetMapping
    public ResponseEntity<List<CargoEmpleado>> listarCargos() {
        return ResponseEntity.ok(cargoEmpleadoService.listarTodo());
    }

    @PostMapping
    public ResponseEntity<CargoEmpleado> crearCargo(@RequestBody CargoEmpleado cargoEmpleado) {
        CargoEmpleado nuevoCargo = cargoEmpleadoService.guardarCargo(cargoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoEmpleado> actualizarCargo(@PathVariable Integer id, @RequestBody CargoEmpleado cargoEmpleado) {
        return cargoEmpleadoService.obtenerPorId(id)
                .map(cargoExistente -> {
                    cargoEmpleado.setId(id);
                    CargoEmpleado cargoActualizado = cargoEmpleadoService.guardarCargo(cargoEmpleado);
                    return ResponseEntity.ok(cargoActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCargo(@PathVariable Integer id) {
        if (cargoEmpleadoService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cargoEmpleadoService.eliminarCargo(id);
        return ResponseEntity.noContent().build();
    }
}
