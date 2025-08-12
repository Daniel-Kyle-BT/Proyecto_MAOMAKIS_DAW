package com.cibertec.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprobante;

    private BigDecimal descuentoTotal;

    private LocalDateTime fechaEmision;

    private BigDecimal igvTotal;

    private BigDecimal precioTotalPedido;

    private BigDecimal subTotal;

    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobante tipoComprobante;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}
