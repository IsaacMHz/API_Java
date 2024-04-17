package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString

public class TrianguloDto {
    @NotNull(message = "El valor de la base no ser nulo")
    private double base;
    @NotNull(message = "El valor de la altura no debe ser nulo")
    private double altura;
}
