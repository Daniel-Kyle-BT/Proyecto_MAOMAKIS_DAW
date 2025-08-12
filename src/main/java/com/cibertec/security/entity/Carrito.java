package com.cibertec.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "carrito")
public class Carrito {

	@EmbeddedId
    private CarritoId id;
    
    @Column(name = "cantidad")
    private int cantidad;

}
