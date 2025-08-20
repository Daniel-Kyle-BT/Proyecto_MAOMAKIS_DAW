
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Comprobante;
import com.cibertec.security.repository.ComprobanteRepository;
import com.cibertec.security.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Override
    public List<Comprobante> listarComprobantes() {
        return comprobanteRepository.findAll();
    }

    @Override
    public Optional<Comprobante> obtenerComprobantePorId(Long idComprobante) {
        return comprobanteRepository.findById(idComprobante);
    }

    @Override
    public Comprobante guardarComprobante(Comprobante comprobante) {
        return comprobanteRepository.save(comprobante);
    }

    @Override
    public void eliminarComprobante(Long idComprobante) {
        comprobanteRepository.deleteById(idComprobante);
    }

	@Override
	public List<Comprobante> buscarComprobantesFiltro(Long idPedido, Long idCliente, Long idEmpleado, Long idCaja, Long idEstado, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
	    return comprobanteRepository.buscarComprobantesFiltro(idPedido, idCliente, idEmpleado, idCaja, idEstado, fechaInicio, fechaFin);
	}

}
