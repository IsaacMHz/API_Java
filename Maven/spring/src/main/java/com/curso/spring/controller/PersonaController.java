package com.curso.spring.controller;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.service.IPersonasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas")

public class PersonaController {

    @Autowired
    private IPersonasService iPersonasService;

    @GetMapping("/personas")
    @Operation(summary = "Operacion para obtener todos los datos de personas")
    public List<Personas> obtenerPersoans(){
        return iPersonasService.findAllPersons();
    }

    @PostMapping("/personas")
    @Operation(summary = "Operacion para guardar personas en la base de datos")
    public ResponseEntity<Personas> guardarPersona(@RequestBody Personas personas){
        return iPersonasService.guardarPersona(personas);
    }

    @PostMapping("/persons")
    @Operation(summary = "Operacion para guardar personas en la base de datos 2")
    public ResponseEntity<Personas> guardarPersona2(@RequestBody PersonaRequest personas){
        return iPersonasService.guardarPersona2(personas);
    }


}
