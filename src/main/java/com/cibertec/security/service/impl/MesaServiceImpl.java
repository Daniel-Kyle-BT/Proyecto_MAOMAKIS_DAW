package com.cibertec.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Mesa;
import com.cibertec.security.repository.MesaRepository;
import com.cibertec.security.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {
	
	@Autowired
    private MesaRepository mesaRepository;
	
	@Override
    public Optional<Mesa> buscarPorId(Long id) {
        return mesaRepository.findById(id);
    }

    @Override
    public Mesa guardarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }

    // 🔹 Nuevo método unificado de lista
    @Override
    public List<Mesa> buscarMesas(Integer idSucursal, Integer idEstado, Integer numeroMesa) {
        return mesaRepository.listarPorFiltrosMesas(idSucursal, idEstado, numeroMesa);
    }

	@Override
	public void cambiarEstado(Long id, Integer idEstado) {
		mesaRepository.modificarEstadoMesa(id, idEstado);
	}
}
