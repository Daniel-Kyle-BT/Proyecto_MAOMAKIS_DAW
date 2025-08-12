package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Distrito;
import com.cibertec.security.repository.DistritoRepository;
import com.cibertec.security.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl  implements DistritoService{

	@Autowired
    private DistritoRepository distritoRepository;

	@Override
	public List<Distrito> listarTodo() {
		return distritoRepository.findAll();
	}

	@Override
	public List<Distrito> listartPorProvinciaId(Integer idProvincia) {
		return distritoRepository.buscarDistritoPorProvincia(idProvincia);
	}
	
}