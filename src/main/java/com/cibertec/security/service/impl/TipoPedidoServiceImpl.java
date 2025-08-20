package com.cibertec.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.security.entity.TipoPedido;
import com.cibertec.security.repository.TipoPedidoRepository;
import com.cibertec.security.service.TipoPedidoService;

@Service
public class TipoPedidoServiceImpl implements TipoPedidoService {

    private final TipoPedidoRepository repo;

    public TipoPedidoServiceImpl(TipoPedidoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TipoPedido> listar() {
        return repo.findAll();
    }

    @Override
    public TipoPedido buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TipoPedido registrar(TipoPedido tipoPedido) {
        return repo.save(tipoPedido);
    }

    @Override
    public TipoPedido actualizar(TipoPedido tipoPedido) {
        return repo.save(tipoPedido);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
