package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.Empleado;

public interface EmpleadoService {

    public Empleado obtenerEmopleadoPorId(Long idEmpleado);
    
    public void cambiarEstadoEmpleado(Long idEmpleado, boolean estado);
    
    public void guardarEmpleado(Empleado reg);
    
    public List<Empleado> listarEmpleadoPorFiltros(Boolean estado,Integer idCargo,Integer idDistrito,Integer idProvincia,Integer idDepartamento);
}
