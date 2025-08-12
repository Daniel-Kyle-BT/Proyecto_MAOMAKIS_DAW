package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Empleado;
import com.cibertec.security.repository.EmpleadoRepository;
import com.cibertec.security.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
    private EmpleadoRepository empleadoRepository;

	@Override
	public Empleado obtenerEmopleadoPorId(Long idEmpleado) {
		return empleadoRepository.findById(idEmpleado).get();
	}

	@Override
	public void cambiarEstadoEmpleado(Long idEmpleado, boolean estado) {
		empleadoRepository.modificarEstadoEmpleado(idEmpleado, estado);
	}

	@Override
	public void guardarEmpleado(Empleado reg) {
		empleadoRepository.save(reg);
	}

	@Override
	public List<Empleado> listarEmpleadoPorFiltros(Boolean estado, Integer idCargo, Integer idDistrito, Integer idProvincia, Integer idDepartamento) {
		return empleadoRepository.buscarEmpleadosFiltro(estado, idCargo, idDistrito, idProvincia, idDepartamento);
	}
}
