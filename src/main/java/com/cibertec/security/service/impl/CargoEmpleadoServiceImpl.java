package com.cibertec.security.service.impl;

import com.cibertec.security.entity.CargoEmpleado;
import com.cibertec.security.repository.CargoEmpleadoRepository;
import com.cibertec.security.service.CargoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoEmpleadoServiceImpl  implements CargoEmpleadoService{

	@Autowired
    private CargoEmpleadoRepository cargoEmpleadoRepository;
    
	@Override
	public List<CargoEmpleado> listarTodo() {
		return cargoEmpleadoRepository.findAll();
	}

}
