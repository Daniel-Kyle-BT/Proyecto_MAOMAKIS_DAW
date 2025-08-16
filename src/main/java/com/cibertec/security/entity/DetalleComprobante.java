package com.cibertec.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_comprobante")
public class DetalleComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_comprobante")
    @EqualsAndHashCode.Include
    private Long idDetalleComprobante;

    @Column(name = "monto_pago", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoPago;

    @ManyToOne
    @JoinColumn(name = "id_comprobante", nullable = false)
    private Comprobante comprobante;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;
}
