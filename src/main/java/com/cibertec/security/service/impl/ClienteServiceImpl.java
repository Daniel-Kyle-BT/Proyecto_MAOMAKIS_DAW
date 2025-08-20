package com.cibertec.security.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Cliente;
import com.cibertec.security.repository.ClienteRepository;
import com.cibertec.security.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final ClienteRepository repo;
	
	public ClienteServiceImpl(ClienteRepository repo) {
        this.repo = repo;
    }

	 @Override
	    public List<Cliente> listarTodos() {
	        return repo.findAll();
	    }

	    @Override
	    public Optional<Cliente> buscarPorId(Long id) {
	        return repo.findById(id);
	    }

	    @Override
	    public Cliente guardar(Cliente cliente) {
	        if (cliente.getFechaRegistro() == null) {
	            cliente.setFechaRegistro(LocalDateTime.now());
	        }
	        return repo.save(cliente);
	    }

	    @Override
	    public void eliminar(Long id) {
	        repo.deleteById(id);
	    }
}