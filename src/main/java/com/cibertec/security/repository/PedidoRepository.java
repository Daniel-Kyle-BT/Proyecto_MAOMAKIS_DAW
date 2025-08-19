
package com.cibertec.security.repository;

import com.cibertec.security.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.estado.id = :idEstado")
    List<Pedido> findByEstado(@Param("idEstado") Integer idEstado);

    @Query("SELECT p FROM Pedido p WHERE p.fechaInicio BETWEEN :fechaInicio AND :fechaFin")
    List<Pedido> findByRangoDeFechas(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
