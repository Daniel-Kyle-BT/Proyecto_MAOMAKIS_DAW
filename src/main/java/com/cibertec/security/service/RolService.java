package com.cibertec.security.service;

import java.util.List;
import java.util.Optional;
import com.cibertec.security.entity.Rol;

public interface RolService {
     
	List<Rol> listar();
    Optional<Rol> obtenerPorId(Integer id);
    Rol registrar(Rol rol);
    Rol actualizar(Rol rol);
    void eliminar(Integer id);
  
}
