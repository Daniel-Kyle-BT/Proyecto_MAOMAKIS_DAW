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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @Column(name = "codigo", nullable = false, columnDefinition = "CHAR(8)")
    private String codigo;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;

    @Column(name = "dni", length = 15, unique = true)
    private String dni;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoEmpleado cargo;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "estado")
    private Boolean estado = true;
}
