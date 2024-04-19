package com.curso.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class TrianguloDto {
    @NotNull(message = "El valor de la base no ser nulo")
    private Double base;
    @NotNull(message = "El valor de la altura no debe ser nulo")
    private Double altura;
}
