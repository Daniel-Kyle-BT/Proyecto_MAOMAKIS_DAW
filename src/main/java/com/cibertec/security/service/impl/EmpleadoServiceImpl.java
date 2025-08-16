package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Empleado;
import com.cibertec.security.repository.EmpleadoRepository;
import com.cibertec.security.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void cambiarEstadoEmpleado(Long idEmpleado, boolean estado) {
        empleadoRepository.modificarEstadoEmpleado(idEmpleado, estado);
    }

    @Override
    public void eliminarEmpleado(Long idEmpleado) {
        empleadoRepository.deleteById(idEmpleado);
    }

    @Override
    public List<Empleado> listarEmpleadoPorFiltros(Boolean estado, Integer idCargo, Integer idDistrito, Integer idProvincia, Integer idDepartamento) {
        return empleadoRepository.buscarEmpleadosFiltro(estado, idCargo, idDistrito, idProvincia, idDepartamento);
    }
}