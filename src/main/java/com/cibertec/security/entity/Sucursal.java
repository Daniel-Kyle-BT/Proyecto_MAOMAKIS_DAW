package com.cibertec.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    @EqualsAndHashCode.Include
    private Integer id;
    
    @Column(name = "codigo", nullable = false, columnDefinition = "CHAR(6)")
    private String codigo;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "pais", length = 50)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
