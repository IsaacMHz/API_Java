package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonaRequest {
    private Long idPersona;
    private String nombre;
    private Integer edad;
    private String genero;
    private Integer idDireccion;
    private Integer idEmpleo;
}
