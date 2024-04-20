package com.curso.spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonaRequest {

    private Long idPersona;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String nombre;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Integer edad;

    @NotBlank(message = "El valor del campo no puede ser nulo o contener s\u00f3lo espacios en blanco")
    private String genero;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Long idDireccion;

    @NotNull(message = "El valor del campo no puede ser nulo")
    private Long idEmpleo;
}
