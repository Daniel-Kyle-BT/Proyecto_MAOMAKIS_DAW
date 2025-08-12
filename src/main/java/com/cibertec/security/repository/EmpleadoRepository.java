package com.cibertec.security.repository;

import com.cibertec.security.entity.Empleado;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Empleado p SET p.estado = :estado WHERE p.id = :idEmpleado")
	public void modificarEstadoEmpleado(@Param("idEmpleado") Long idEmpleado, @Param("estado") boolean estado);
	
	@Query("""	
			    SELECT e FROM Empleado e WHERE e.estado = :estado
			      AND (:idCargo = 0 OR e.cargo.id = :idCargo)
			      AND (:idDistrito = 0 OR e.distrito.id = :idDistrito)
			      AND (:idProvincia = 0 OR e.distrito.provincia.id = :idProvincia)
			      AND (:idDepartamento = 0 OR e.distrito.provincia.departamento.id = :idDepartamento)
			""")
	List<Empleado> buscarEmpleadosFiltro(@Param("estado") Boolean estado, @Param("idCargo") Integer idCargo,
			@Param("idDistrito") Integer idDistrito, @Param("idProvincia") Integer idProvincia,
			@Param("idDepartamento") Integer idDepartamento);
}
