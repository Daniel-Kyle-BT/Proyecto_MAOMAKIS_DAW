package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.security.entity.MetodoPago;

public interface MetodoPagoService {
	List<MetodoPago>listar();
	Optional<MetodoPago> obtenerPorId(Integer id);
	MetodoPago registrar(MetodoPago metodoPago);
	MetodoPago actualizar(MetodoPago metodoPago);
	void eliminar(Integer id);

}
