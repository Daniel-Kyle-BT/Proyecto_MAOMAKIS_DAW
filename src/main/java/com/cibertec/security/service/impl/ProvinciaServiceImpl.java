package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Provincia;
import com.cibertec.security.repository.ProvinciaRepository;
import com.cibertec.security.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl  implements ProvinciaService{

	@Autowired
    private ProvinciaRepository provinciaRepository;

	@Override
	public List<Provincia> listarTodo() {
		return provinciaRepository.findAll();
	}

	@Override
	public List<Provincia> listarPorDepatamentoId(Integer idDepartamento) {
		return provinciaRepository.buscarProvinciaPorDepartamento(idDepartamento);
	}
}