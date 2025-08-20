package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.Mesa;

public interface MesaService {  
	List<Mesa> lista();
	Mesa buscarPorId(Long id);
	Mesa registrar(Mesa mesa);
	Mesa actualizar(Mesa mesa);
	void eliminar (Long id);
	// 🔹 Nuevo método para búsquedas con filtros opcionales
    List<Mesa> buscarMesas(Integer idSucursal, Integer idEstado, Integer numeroMesa);
}
