package com.curso.spring.controller;

import com.curso.spring.dto.Persona;
import com.curso.spring.service.IEjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/maven/spring")
@Slf4j
public class HolaMundoController {

    @Autowired
    private IEjerciciosService iEjerciciosService;

    @GetMapping("/hola")
    public String Holamundo(){
        return "Hola mundo con maven";
    }

    @GetMapping(path = "/hola/{nombre}")
    public String holaMundoCustom(@PathVariable String nombre){

        log.info("El nombre que se envia atraves de la url es: " + nombre);
        return "Hola mundo " + nombre;
    }

    @PostMapping("/persona")
    public Persona datosPersona(@RequestBody Persona persona){

        return persona;
    }

    @GetMapping("/nombres")
    public List<String> getNombres(){
        return iEjerciciosService.getNombres();
    }
}
