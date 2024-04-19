package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter

public class DireccionRequest {
    @NotNull(message = "El valor del campo no puede ser nulo")
    private Long direccion_id;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    private String calle;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    private String ciudad;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    private String estado;

    @NotBlank(message = "El valor del campo no puede ser nulo o s\u00f3lo contener espacios en blanco")
    private String codigo_postal;
}
