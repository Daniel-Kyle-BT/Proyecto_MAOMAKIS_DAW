
package com.cibertec.security.repository;

import com.cibertec.security.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.cliente.id = :idCliente")
    List<Reserva> findByCliente(@Param("idCliente") Long idCliente);

    @Query("SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva")
    List<Reserva> findByFechaReserva(@Param("fechaReserva") LocalDate fechaReserva);
}
