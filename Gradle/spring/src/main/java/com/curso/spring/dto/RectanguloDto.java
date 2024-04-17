package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString

public class RectanguloDto {
    @NotNull(message = "El valor de la base no puede ser nulo")
    public double base;
    @NotNull(message = "El valor de la altura no puede ser nulo")
    private double altura;

}
