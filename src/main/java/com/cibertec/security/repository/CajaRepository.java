
package com.cibertec.security.repository;

import com.cibertec.security.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajaRepository extends JpaRepository<Caja, Integer> {

@Query("""
    SELECT c FROM Caja c
    WHERE (:idSucursal = 0 OR c.sucursal.id = :idSucursal)
      AND (:idEstado = 0 OR c.estado.id = :idEstado)
""")
List<Caja> buscarCajasFiltro(
    @Param("idSucursal") Integer idSucursal,
    @Param("idEstado") Integer idEstado
);
}
