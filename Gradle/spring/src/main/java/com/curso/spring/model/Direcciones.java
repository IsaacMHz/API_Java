package com.curso.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "direcciones")
@Setter
@Getter
public class Direcciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id",nullable = false)
    private Long direccion_id;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    @Column(name = "calle", length = 100)
    private String calle;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    @Column(name = "ciudad",length = 100)
    private String ciudad;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    @Column(name = "estado",length = 100)
    private String estado;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    @Column(name = "codigo_postal")
    private String codigo_postal;

}
