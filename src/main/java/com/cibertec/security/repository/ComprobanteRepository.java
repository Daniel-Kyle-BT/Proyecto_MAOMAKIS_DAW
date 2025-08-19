
package com.cibertec.security.repository;

import com.cibertec.security.entity.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {

    @Query("SELECT c FROM Comprobante c WHERE c.cliente.id = :idCliente")
    List<Comprobante> findByCliente(@Param("idCliente") Long idCliente);

    @Query("SELECT c FROM Comprobante c WHERE c.fechaEmision BETWEEN :fechaInicio AND :fechaFin")
    List<Comprobante> findByRangoDeFechas(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
