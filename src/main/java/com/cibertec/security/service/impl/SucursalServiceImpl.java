package com.cibertec.security.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Sucursal;
import com.cibertec.security.repository.SucursalRepository;
import com.cibertec.security.service.SucursalService;
@Service
public class SucursalServiceImpl implements SucursalService{
    
	@Autowired
    private SucursalRepository sucursalRepository;

    
	@Override
	public List<Sucursal> listar() {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll();
	}

	@Override
	public Optional<Sucursal> obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return sucursalRepository.findById(id);
	}

	@Override
	public Sucursal registrar(Sucursal sucursal) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal actualizar(Sucursal sucursal) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		sucursalRepository.deleteById(id);
	}

}

