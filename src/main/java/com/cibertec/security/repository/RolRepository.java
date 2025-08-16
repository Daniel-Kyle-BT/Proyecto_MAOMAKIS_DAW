package com.cibertec.security.repository;

import com.cibertec.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByDescripcion(String descripcion);
}
