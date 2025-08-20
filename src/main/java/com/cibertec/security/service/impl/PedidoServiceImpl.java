
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Pedido;
import com.cibertec.security.repository.PedidoRepository;
import com.cibertec.security.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }


	@Override
	public List<Pedido> buscarPedidosFiltro(Long idEmpleado, Integer idEstado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
	    return pedidoRepository.buscarPedidosFiltro(idEmpleado, idEstado, fechaInicio, fechaFin);
	}
}
