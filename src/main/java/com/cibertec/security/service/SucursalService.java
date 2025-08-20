package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.security.entity.Sucursal;

public interface SucursalService{
	List<Sucursal>listar();
	  Optional<Sucursal> obtenerPorId(Integer id);
	  Sucursal registrar(Sucursal sucursal);
	  Sucursal actualizar(Sucursal sucursal);
	  void eliminar(Integer id);

}
