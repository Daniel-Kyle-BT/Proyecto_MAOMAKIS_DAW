package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.Distrito;

public interface DistritoService {

	List<Distrito> listarTodo();
	
	List<Distrito> listartPorProvinciaId(Integer idProvincia);
}
