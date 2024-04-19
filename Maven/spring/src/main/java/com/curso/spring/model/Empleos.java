package com.curso.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "empleos")
@Getter
@Setter
public class Empleos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleo_id",nullable = false)
    private Long empleo_id;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    @Column(name = "titulo",length = 100)
    private String titulo;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    @Column(name = "empresa",length = 100)
    private String empresa;

    @NotNull(message = "El valor del campo no puede ser nulo")
    @Column(name = "salario")
    private Double salario;
}
