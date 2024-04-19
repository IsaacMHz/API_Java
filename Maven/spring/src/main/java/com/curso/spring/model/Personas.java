package com.curso.spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "personas")
@Getter
@Setter
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", nullable = false)
    private Long personaId;
    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @NotNull(message = "El valor del campo no puede ser nulo")
    @Column(name = "edad")
    private Integer edad;
    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    @Column(name = "genero")
    private String genero;
    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direcciones direccionId;
    @ManyToOne
    @JoinColumn(name = "empleo_id")
    private Empleos empleoId;
}
