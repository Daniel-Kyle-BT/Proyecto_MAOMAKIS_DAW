package com.cibertec.security.repository;

import com.cibertec.security.entity.Provincia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
	
	@Query("SELECT e FROM Provincia e WHERE e.departamento.id = :idDepartamento")
	List<Provincia> buscarProvinciaPorDepartamento(@Param("idDepartamento") Integer idDepartamento);
}
