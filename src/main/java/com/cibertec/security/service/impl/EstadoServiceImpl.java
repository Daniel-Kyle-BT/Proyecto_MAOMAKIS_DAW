
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Estado;
import com.cibertec.security.repository.EstadoRepository;
import com.cibertec.security.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    @Override
    public Estado guardar(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void eliminar(Long id) {
        estadoRepository.deleteById(id);
    }
}
