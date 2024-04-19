package com.curso.spring.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class CirculoDto {
    @NotNull(message = "El valor del radio no puede ser nulo")
    private Double radio;
}
