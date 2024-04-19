package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class PersonaRequest {
    @NotNull(message = "El valor del campo no puede ser nulo")
    private Long idPersona;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String nombre;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Integer edad;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String genero;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Integer idDireccion;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Integer idEmpleo;
}
