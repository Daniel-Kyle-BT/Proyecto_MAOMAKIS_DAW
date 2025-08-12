package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.Provincia;

public interface ProvinciaService {

	List<Provincia> listarTodo();
	
	List<Provincia> listarPorDepatamentoId(Integer idDepartamento);
}
