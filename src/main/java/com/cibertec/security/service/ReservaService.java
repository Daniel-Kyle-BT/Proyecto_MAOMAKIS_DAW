
package com.cibertec.security.service;

import com.cibertec.security.entity.Reserva;
import java.time.LocalDate;
import java.util.List;

public interface ReservaService {
    List<Reserva> listarTodos();
    Reserva buscarPorId(Long id);
    Reserva guardar(Reserva reserva);
    void eliminar(Long id);
    List<Reserva> buscarReservasFiltro(Long idCliente, Long idEstado, Long idMesa, LocalDate fechaReserva);
}
