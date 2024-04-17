package com.curso.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString

public class Persona {

    @NotBlank(message = "No puede ser vacio o nulo")
    private String nombre;
    @NotBlank(message = "No puede ser vacio o nulo")
    private String apellidoPaterno;
    @NotBlank(message = "No puede ser vacio o nulo")
    private String apellidoMaterno;
    @Pattern( regexp = "\\d{1,3}") //Sirve para meter expresiones regulares
    private String edad;
    @NotBlank(message = "No puede ser vacio o nulo")
    private String genero;
    @Email
    private  String email;
}
