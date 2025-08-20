package com.cibertec.security.repository;


import com.cibertec.security.entity.Estado;
import com.cibertec.security.entity.Mesa;
import com.cibertec.security.entity.Sucursal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
	@Query("""
		       SELECT m FROM Mesa m
		       WHERE (:sucursal IS NULL OR m.sucursal = :sucursal)
		         AND (:estado IS NULL OR m.estado = :estado)
		         AND (:numeroMesa IS NULL OR m.numeroMesa = :numeroMesa)
		       """)
		List<Mesa> buscarMesas(@Param("sucursal") Sucursal sucursal,
		                       @Param("estado") Estado estado,
		                       @Param("numeroMesa") Integer numeroMesa);

}
