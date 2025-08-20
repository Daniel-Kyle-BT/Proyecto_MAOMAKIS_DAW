package com.cibertec.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Rol;
import com.cibertec.security.repository.RolRepository;
import com.cibertec.security.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	 @Autowired
	    private RolRepository rolRepository;

	 @Override
	 public List<Rol> listar() {
		// TODO Auto-generated method stub
	        return rolRepository.findAll();
	 }

	 @Override
	 public Optional<Rol> obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
	        return rolRepository.findById(id);
	 }

	 @Override
	 public Rol registrar(Rol rol) {
		// TODO Auto-generated method stub
	        return rolRepository.save(rol);
	 }

	 @Override
	 public Rol actualizar(Rol rol) {
		// TODO Auto-generated method stub
	        return rolRepository.save(rol);
	 }

	 @Override
	 public void eliminar(Integer id) {
		// TODO Auto-generated method stub
	        rolRepository.deleteById(id);

	 }
}