package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.security.entity.Mesa;

public interface MesaService {  
	
	Optional<Mesa> buscarPorId(Long id);
	Mesa guardarMesa(Mesa mesa);
	void eliminar (Long id);
	void cambiarEstado(Long id, Integer idEstado);
    List<Mesa> buscarMesas(Integer idSucursal, Integer idEstado, Integer numeroMesa);
}
