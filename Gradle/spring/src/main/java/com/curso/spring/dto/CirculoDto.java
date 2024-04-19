package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString

public class CirculoDto {
    @NotNull(message = "El valor del radio no puede ser nulo")
    private Double radio;
}
