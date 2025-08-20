
package com.cibertec.security.service;

import com.cibertec.security.entity.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> listarTodos();
    Estado buscarPorId(Long id);
    Estado guardar(Estado estado);
    void eliminar(Long id);
}
