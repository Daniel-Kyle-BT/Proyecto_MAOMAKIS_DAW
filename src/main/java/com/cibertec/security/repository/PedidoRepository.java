
package com.cibertec.security.repository;

import com.cibertec.security.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


@Query("""
    SELECT p FROM Pedido p
    WHERE (:idEmpleado = 0 OR p.empleado.id = :idEmpleado)
      AND (:idEstado = 0 OR p.estado.id = :idEstado)
      AND (
            (:fechaInicio IS NULL OR :fechaFin IS NULL)
            OR (p.fechaInicio BETWEEN :fechaInicio AND :fechaFin)
          )
""")
List<Pedido> buscarPedidosFiltro(
    @Param("idEmpleado") Long idEmpleado,
    @Param("idEstado") Integer idEstado,
    @Param("fechaInicio") LocalDateTime fechaInicio,
    @Param("fechaFin") LocalDateTime fechaFin
);

}
