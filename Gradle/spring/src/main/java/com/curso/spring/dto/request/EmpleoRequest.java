package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpleoRequest {
    @NotNull(message = "El valor del campo no puede ser nulo")
    private Long empleo_id;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String titulo;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String empresa;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Double salario;
}
