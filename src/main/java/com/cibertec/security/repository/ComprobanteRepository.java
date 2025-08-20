package com.cibertec.security.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.security.entity.Comprobante;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {

	@Query("""
			    SELECT c FROM Comprobante c
			    WHERE (:idPedido = 0 OR c.pedido.id = :idPedido)
			      AND (:idCliente = 0 OR c.cliente.id = :idCliente)
			      AND (:idEmpleado = 0 OR c.empleado.id = :idEmpleado)
			      AND (:idCaja = 0 OR c.caja.id = :idCaja)
			      AND (:idEstado = 0 OR c.estado.id = :idEstado)
			      AND (
			            (:fechaInicio IS NULL OR :fechaFin IS NULL)
			            OR (c.fechaEmision BETWEEN :fechaInicio AND :fechaFin)
			          )
			""")
	List<Comprobante> buscarComprobantesFiltro(@Param("idPedido") Long idPedido, @Param("idCliente") Long idCliente,
			@Param("idEmpleado") Long idEmpleado, @Param("idCaja") Long idCaja, @Param("idEstado") Long idEstado,
			@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

}