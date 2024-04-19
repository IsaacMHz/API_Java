package com.curso.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RectanguloDto {
    @NotNull(message = "El valor de la base no puede ser nulo")
    public Double base;
    @NotNull(message = "El valor de la altura no puede ser nulo")
    private Double altura;

}
