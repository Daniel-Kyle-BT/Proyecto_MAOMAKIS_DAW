package com.cibertec.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.security.entity.DetallePedido;
import com.cibertec.security.entity.DetallePedidoId;

@Repository	
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoId>{

}
