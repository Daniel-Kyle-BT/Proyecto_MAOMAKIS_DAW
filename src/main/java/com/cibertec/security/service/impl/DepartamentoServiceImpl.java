package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Departamento;
import com.cibertec.security.repository.DepartamentoRepository;
import com.cibertec.security.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl  implements DepartamentoService{

	@Autowired
    private DepartamentoRepository departamentoRepository ;
	
	@Override
	public List<Departamento> listarTodo() {
		return departamentoRepository.findAll();
	}
}