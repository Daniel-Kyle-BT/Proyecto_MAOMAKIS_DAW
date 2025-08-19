
package com.cibertec.security.service;

import com.cibertec.security.entity.CargoEmpleado;

import java.util.List;
import java.util.Optional;

public interface CargoEmpleadoService {
    List<CargoEmpleado> listarTodo();
    CargoEmpleado guardarCargo(CargoEmpleado cargoEmpleado);
    Optional<CargoEmpleado> obtenerPorId(Integer id);
    void eliminarCargo(Integer id);
}
