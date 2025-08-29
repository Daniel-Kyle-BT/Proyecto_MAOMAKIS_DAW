package com.cibertec.security.repository;

import com.cibertec.security.entity.DetalleComprobante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetalleComprobanteRepository extends JpaRepository<DetalleComprobante, Long> {
 
	@Query("""
            SELECT d FROM DetalleComprobante d
            WHERE d.comprobante.idComprobante = :idComprobante
        """)
        List<DetalleComprobante> findByComprobanteId(@Param("idComprobante") Long idComprobante);
	
}
