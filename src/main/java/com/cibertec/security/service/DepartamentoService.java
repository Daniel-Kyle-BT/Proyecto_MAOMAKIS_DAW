package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.Departamento;

public interface DepartamentoService {

	List<Departamento> listarTodo();
	Departamento buscarPorId(Integer id);
	Departamento registrar(Departamento departamento);
	Departamento actualizar(Departamento departamento);
	void eliminar(Integer id);	
}
