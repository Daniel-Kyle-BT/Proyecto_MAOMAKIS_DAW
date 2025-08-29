package com.cibertec.security.repository;

import com.cibertec.security.entity.Distrito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

	@Query("""
			    SELECT d FROM Distrito d
			    WHERE  d.provincia.id = :idProvincia
			      AND (:descripcion IS NULL OR LOWER(d.descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%')))
			""")
	List<Distrito> buscarDistritosFiltro(@Param("idProvincia") Integer idProvincia,
			@Param("descripcion") String descripcion);
}
