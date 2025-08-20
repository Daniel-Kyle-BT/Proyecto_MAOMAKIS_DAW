
package com.cibertec.security.service;

import com.cibertec.security.entity.Distrito;
import java.util.List;

public interface DistritoService {
    List<Distrito> listarTodos();
    Distrito buscarPorId(Integer id);
    Distrito guardar(Distrito distrito);
    void eliminar(Integer id);
    List<Distrito> buscarDistritosFiltro(Integer idProvincia, String descripcion);
}
