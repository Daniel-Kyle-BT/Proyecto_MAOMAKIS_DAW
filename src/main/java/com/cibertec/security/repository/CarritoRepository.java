package com.cibertec.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.security.entity.Carrito;
import com.cibertec.security.entity.CarritoId;

@Repository	
public interface CarritoRepository extends JpaRepository<Carrito, CarritoId>{

}
