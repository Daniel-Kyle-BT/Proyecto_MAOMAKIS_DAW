
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Caja;
import com.cibertec.security.repository.CajaRepository;
import com.cibertec.security.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajaServiceImpl implements CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public List<Caja> listarCajas() {
        return cajaRepository.findAll();
    }

    @Override
    public Optional<Caja> obtenerCajaPorId(Integer idCaja) {
        return cajaRepository.findById(idCaja);
    }

    @Override
    public Caja guardarCaja(Caja caja) {
        return cajaRepository.save(caja);
    }

    @Override
    public void eliminarCaja(Integer idCaja) {
        cajaRepository.deleteById(idCaja);
    }

	@Override
	public List<Caja> buscarCajasFiltro(Integer idSucursal, Integer idEstado) {
	    return cajaRepository.buscarCajasFiltro(idSucursal, idEstado);
	}
}
