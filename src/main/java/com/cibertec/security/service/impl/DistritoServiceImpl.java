
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Distrito;
import com.cibertec.security.repository.DistritoRepository;
import com.cibertec.security.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<Distrito> listarTodos() {
        return distritoRepository.findAll();
    }

    @Override
    public Distrito buscarPorId(Integer id) {
        return distritoRepository.findById(id.longValue()).orElse(null);
    }

    @Override
    public Distrito guardar(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    public void eliminar(Integer id) {
        distritoRepository.deleteById(id.longValue());
    }

    @Override
    public List<Distrito> buscarDistritosFiltro(Integer idProvincia, String descripcion) {
        return distritoRepository.buscarDistritosFiltro(idProvincia, descripcion);
    }
}
