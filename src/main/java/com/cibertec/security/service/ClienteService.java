package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.security.entity.Cliente;

public interface ClienteService {
	List<Cliente> listarTodos();
	   Optional<Cliente>buscarPorId(Long id);
	   Cliente guardar(Cliente cliente);
	   void eliminar(Long id);
}
