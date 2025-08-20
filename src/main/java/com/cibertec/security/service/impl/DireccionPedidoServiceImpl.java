package com.cibertec.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.security.entity.DireccionPedido;
import com.cibertec.security.repository.DireccionPedidoRepository;
import com.cibertec.security.service.DireccionPedidoService;

@Service
public class DireccionPedidoServiceImpl implements DireccionPedidoService {

    private final DireccionPedidoRepository repo;

    public DireccionPedidoServiceImpl(DireccionPedidoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<DireccionPedido> listar() {
        return repo.findAll();
    }

    @Override
    public DireccionPedido buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public DireccionPedido registrar(DireccionPedido direccionPedido) {
        return repo.save(direccionPedido);
    }

    @Override
    public DireccionPedido actualizar(DireccionPedido direccionPedido) {
        return repo.save(direccionPedido);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
