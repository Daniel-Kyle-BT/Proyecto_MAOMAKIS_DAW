
package com.cibertec.security.service;

import com.cibertec.security.entity.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> listarTodos();
    Estado buscarPorId(Integer id);
    Estado guardar(Estado estado);
    void eliminar(Integer id);
}
