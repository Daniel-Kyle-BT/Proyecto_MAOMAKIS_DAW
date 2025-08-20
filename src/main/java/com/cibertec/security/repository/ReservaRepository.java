
package com.cibertec.security.repository;

import com.cibertec.security.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {


@Query("""
    SELECT r FROM Reserva r
    WHERE (:idCliente = 0 OR r.cliente.id = :idCliente)
      AND (:idEstado = 0 OR r.estado.id = :idEstado)
      AND (:idMesa = 0 OR r.mesa.id = :idMesa)
      AND (:fechaReserva IS NULL OR r.fechaReserva = :fechaReserva)
""")
List<Reserva> buscarReservasFiltro(
    @Param("idCliente") Long idCliente,
    @Param("idEstado") Long idEstado,
    @Param("idMesa") Long idMesa,
    @Param("fechaReserva") LocalDate fechaReserva
);

}
