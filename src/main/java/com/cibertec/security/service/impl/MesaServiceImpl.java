package com.cibertec.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Estado;
import com.cibertec.security.entity.Mesa;
import com.cibertec.security.entity.Sucursal;
import com.cibertec.security.repository.EstadoRepository;
import com.cibertec.security.repository.MesaRepository;
import com.cibertec.security.repository.SucursalRepository;
import com.cibertec.security.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {
	
    private final MesaRepository mesaRepository;
    private final SucursalRepository sucursalRepository;
    private final EstadoRepository estadoRepository;

    public MesaServiceImpl(MesaRepository mesaRepository,
                           SucursalRepository sucursalRepository,
                           EstadoRepository estadoRepository) {
        this.mesaRepository = mesaRepository;
        this.sucursalRepository = sucursalRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Mesa> lista() {
        return mesaRepository.findAll();
    }

    @Override
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    @Override
    public Mesa registrar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa actualizar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }

    // 🔹 Nuevo método unificado de búsqueda
    @Override
    public List<Mesa> buscarMesas(Integer idSucursal, Integer idEstado, Integer numeroMesa) {
        Sucursal sucursal = null;
        Estado estado = null;

        if (idSucursal != null) {
            sucursal = sucursalRepository.findById(idSucursal).orElse(null);
        }

        if (idEstado != null) {
            estado = estadoRepository.findById(idEstado).orElse(null);
        }

        return mesaRepository.buscarMesas(sucursal, estado, numeroMesa);
    }
}
