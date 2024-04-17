package com.curso.spring.controller;

import com.curso.spring.dto.Persona;
import com.curso.spring.service.IEjerciciosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/curso/spring")
@Slf4j
@Tag(name = "Hola Mundo Controller")
public class HolaMundoController {

    @Autowired
    private IEjerciciosService iEjerciciosService;

    @GetMapping("/hola")
    @Operation(summary = "Operaci\u00f3n para mostrar un hola mundo")
    public String holamundo(){
        return "Hola mundo desde spring";
    }

    @GetMapping(path = "/hola/{nombre}")
    @Operation(summary = "Operaci\u00f3n para mostrar un hola mundo pasando un par\u00e1metro")
    public String holaMundoCustom(@PathVariable String nombre){

        log.info("El nombre que se envia atraves de la url es: " + nombre);
        return "Hola mundo " + nombre;
    }

    @PostMapping("/persona")
    @Operation(summary = "Operaci\u00f3n para mostrar un objeto persona")
    public Persona datosPersona(@Valid @RequestBody Persona persona){
        return persona;
    }

    @GetMapping("/nombres")
    @Operation(summary = "Operaci\u00f3n para mostrar nombres de una lista")
    public List<String> getNombres(){
        return iEjerciciosService.getNombres();
    }
}
