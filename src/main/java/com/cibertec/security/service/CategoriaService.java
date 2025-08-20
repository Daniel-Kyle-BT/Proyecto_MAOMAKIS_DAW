
package com.cibertec.security.service;

import com.cibertec.security.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Integer idCategoria);
    Categoria guardarCategoria(Categoria categoria);
    void eliminarCategoria(Integer idCategoria);
}
