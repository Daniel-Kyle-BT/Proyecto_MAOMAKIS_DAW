package com.cibertec.security.repository;

import com.cibertec.security.entity.Distrito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

	@Query("SELECT e FROM Distrito e WHERE e.provincia.id = :idProvincia")
	List<Distrito> buscarDistritoPorProvincia(@Param("idProvincia") Integer idProvincia);
}
