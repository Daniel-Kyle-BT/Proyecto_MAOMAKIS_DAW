package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.DireccionPedido;

public interface DireccionPedidoService {
	List<DireccionPedido> listar();
    DireccionPedido buscarPorId(Long id);
    DireccionPedido registrar(DireccionPedido direccionPedido);
    DireccionPedido actualizar(DireccionPedido direccionPedido);
    void eliminar(Long id);
}
