package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.security.entity.Empleado;


public interface EmpleadoService {

    Optional<Empleado> obtenerEmpleadoPorId(Long idEmpleado);

    Empleado guardarEmpleado(Empleado empleado);

    void cambiarEstadoEmpleado(Long idEmpleado, boolean estado);

    void eliminarEmpleado(Long idEmpleado);

    List<Empleado> listarEmpleadoPorFiltros(Boolean estado, Integer idCargo, Integer idDistrito, Integer idProvincia, Integer idDepartamento);
}
