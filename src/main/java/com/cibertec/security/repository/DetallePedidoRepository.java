package com.cibertec.security.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.security.entity.DetallePedido;
import com.cibertec.security.entity.DetallePedidoId;


@Repository	
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoId>{
    @Query("""
            SELECT d FROM DetallePedido d
            WHERE d.id.pedido.idPedido = :idPedido
        """)
    List<DetallePedido> findByPedidoId(@Param("idPedido") Long idPedido);	
}
