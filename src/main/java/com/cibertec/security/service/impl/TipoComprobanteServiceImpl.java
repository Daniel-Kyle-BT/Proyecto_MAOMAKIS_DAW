
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.TipoComprobante;
import com.cibertec.security.repository.TipoComprobanteRepository;
import com.cibertec.security.service.TipoComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Override
    public List<TipoComprobante> listarTodos() {
        return tipoComprobanteRepository.findAll();
    }

    @Override
    public TipoComprobante buscarPorId(Long id) {
        return tipoComprobanteRepository.findById(id).orElse(null);
    }

    @Override
    public TipoComprobante guardar(TipoComprobante tipoComprobante) {
        return tipoComprobanteRepository.save(tipoComprobante);
    }

    @Override
    public void eliminar(Long id) {
        tipoComprobanteRepository.deleteById(id);
    }
}
