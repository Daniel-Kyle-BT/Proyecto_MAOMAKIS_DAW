package com.cibertec.security.service;

import java.util.List;

import com.cibertec.security.entity.TipoPedido;

public interface TipoPedidoService {
    List<TipoPedido> listar();
    TipoPedido buscarPorId(Integer id);
    TipoPedido registrar(TipoPedido tipoPedido);
    TipoPedido actualizar(TipoPedido tipoPedido);
    void eliminar(Integer id);
}
