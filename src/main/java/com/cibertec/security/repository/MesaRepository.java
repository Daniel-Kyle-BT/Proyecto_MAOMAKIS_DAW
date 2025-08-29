package com.cibertec.security.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.security.entity.Mesa;

import jakarta.transaction.Transactional;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
	@Query("""
			SELECT m FROM Mesa m
			WHERE (:sucursal = 0 OR m.sucursal.id = :sucursal)
			  AND (:idEstado = 0 OR m.estado.id = :idEstado)
			  AND (:numeroMesa = 0 OR  m.numeroMesa = :numeroMesa)
			""")
	List<Mesa> listarPorFiltrosMesas(@Param("sucursal") Integer sucursal, @Param("idEstado") Integer idEstado,
			@Param("numeroMesa") Integer numeroMesa);

	@Modifying
	@Transactional
	@Query("UPDATE Mesa m SET m.estado.id = :idEstado WHERE m.id = :idMesa")
	public void modificarEstadoMesa(@Param("idMesa") Long idMesa, @Param("idEstado") Integer idEstado);

}
