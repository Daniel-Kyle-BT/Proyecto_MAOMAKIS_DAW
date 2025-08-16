package com.cibertec.security.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class DetallePedidoId {

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @EqualsAndHashCode.Include
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_platillo")
    @EqualsAndHashCode.Include
    private Menu menu;
}
