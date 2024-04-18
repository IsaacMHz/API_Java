package com.curso.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "personas")
@Getter
@Setter
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", nullable = false)
    private Long personaId;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "genero")
    private String genero;
    @Column(name = "direccion_id")
    private Integer direccionId;
    @Column(name = "empleo_id")
    private Integer empleoId;
}
