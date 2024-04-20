package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class DireccionRequest {

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
