
package com.cibertec.security.repository;

import com.cibertec.security.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajaRepository extends JpaRepository<Caja, Integer> {

    @Query("SELECT c FROM Caja c WHERE c.sucursal.id = :idSucursal")
    List<Caja> findBySucursal(@Param("idSucursal") Integer idSucursal);

    @Query("SELECT c FROM Caja c WHERE c.estado.id = :idEstado")
    List<Caja> findByEstado(@Param("idEstado") Integer idEstado);
}
