
package com.cibertec.security.service;

import com.cibertec.security.entity.Caja;

import java.util.List;
import java.util.Optional;

public interface CajaService {
    List<Caja> listarCajas();
    Optional<Caja> obtenerCajaPorId(Integer idCaja);
    Caja guardarCaja(Caja caja);
    void eliminarCaja(Integer idCaja);
List<Caja> buscarCajasFiltro(Integer idSucursal, Integer idEstado);
}
