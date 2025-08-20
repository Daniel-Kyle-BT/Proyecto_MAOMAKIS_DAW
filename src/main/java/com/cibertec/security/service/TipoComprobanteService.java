
package com.cibertec.security.service;

import com.cibertec.security.entity.TipoComprobante;
import java.util.List;

public interface TipoComprobanteService {
    List<TipoComprobante> listarTodos();
    TipoComprobante buscarPorId(Long id);
    TipoComprobante guardar(TipoComprobante tipoComprobante);
    void eliminar(Long id);
}
