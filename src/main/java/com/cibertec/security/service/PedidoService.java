
package com.cibertec.security.service;

import com.cibertec.security.entity.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listarPedidos();
    Optional<Pedido> obtenerPedidoPorId(Long idPedido);
    Pedido guardarPedido(Pedido pedido);
    void eliminarPedido(Long idPedido);
    List<Pedido> listarPedidosPorEstado(Integer idEstado);
    List<Pedido> listarPedidosPorRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
