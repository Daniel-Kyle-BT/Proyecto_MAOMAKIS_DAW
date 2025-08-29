package com.cibertec.security.repository;

import com.cibertec.security.entity.MetodoPago;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
	Optional<MetodoPago>findByDescripcion(String descripcion);
}
