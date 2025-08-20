
package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Reserva;
import com.cibertec.security.repository.ReservaRepository;
import com.cibertec.security.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public List<Reserva> buscarReservasFiltro(Long idCliente, Long idEstado, Long idMesa, LocalDate fechaReserva) {
        return reservaRepository.buscarReservasFiltro(idCliente, idEstado, idMesa, fechaReserva);
    }
}
