package com.cibertec.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.security.entity.MetodoPago;
import com.cibertec.security.repository.MetodoPagoRepository;
import com.cibertec.security.service.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService{
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

	@Override
	public List<MetodoPago> listar() {
		// TODO Auto-generated method stub
		return metodoPagoRepository.findAll();
	}

	@Override
	public Optional<MetodoPago> obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return metodoPagoRepository.findById(id);
	}

	@Override
	public MetodoPago registrar(MetodoPago metodoPago) {
		// TODO Auto-generated method stub
		return metodoPagoRepository.save(metodoPago);
	}

	@Override
	public MetodoPago actualizar(MetodoPago metodoPago) {
		// TODO Auto-generated method stub
		return metodoPagoRepository.save(metodoPago);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		  metodoPagoRepository.deleteById(id);
	}
    
    
}
