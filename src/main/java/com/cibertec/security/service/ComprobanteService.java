
package com.cibertec.security.service;

import com.cibertec.security.entity.Comprobante;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ComprobanteService {
    List<Comprobante> listarComprobantes();
    Optional<Comprobante> obtenerComprobantePorId(Long idComprobante);
    Comprobante guardarComprobante(Comprobante comprobante);
    void eliminarComprobante(Long idComprobante);
List<Comprobante> buscarComprobantesFiltro(Long idPedido, Long idCliente, Long idEmpleado, Long idCaja, Long idEstado, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
