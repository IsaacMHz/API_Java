package com.curso.spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleoRequest {

    private Long empleo_id;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String titulo;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String empresa;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Double salario;
}
