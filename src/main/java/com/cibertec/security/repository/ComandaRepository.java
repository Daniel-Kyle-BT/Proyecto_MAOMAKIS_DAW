package com.cibertec.security.repository;

import com.cibertec.security.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}
