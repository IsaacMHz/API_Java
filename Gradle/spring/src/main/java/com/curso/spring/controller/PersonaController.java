package com.curso.spring.controller;

import com.curso.spring.dto.Persona;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.response.DatosPersonaResponse;
import com.curso.spring.service.IPersonasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas")

public class PersonaController {

    @Autowired
    private IPersonasService iPersonasService;

    @GetMapping("/obtener-personas")
    @Operation(summary = "Operaci\u00f3n para obtener todos los datos de personas")
    public List<Personas> obtenerPersoans(){
        return iPersonasService.findAllPersons();
    }

    @PostMapping("/insertar-persona/1")
    @Operation(summary = "Operaci\u00f3n para guardar una persona en la base de datos")
    public ResponseEntity<Personas> guardarPersona(@Valid @RequestBody Personas personas){
        return iPersonasService.guardarPersona(personas);
    }

    @PostMapping("/insertar-persona/2")
    @Operation(summary = "Operaci\u00f3n para guardar una persona en la base de datos")
    public ResponseEntity<Personas> guardarPersona2(@Valid @RequestBody PersonaRequest personas){
        return iPersonasService.guardarPersona2(personas);
    }

    @GetMapping("/obtener-persona/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener los datos de una persona por id")
    public Personas buscarPersonaPorId(@PathVariable Long id){
        return iPersonasService.buscarPersonaPorId(id);
    }

    @PutMapping("/actualizar-persona")
    @Operation(summary = "Operaci\u00f3n para actualizar los datos de una persona")
    public ResponseEntity<Object> updatePersona(@Valid @RequestBody PersonaRequest request){
        return iPersonasService.updatePersona(request);
    }

    @DeleteMapping("/delete-persona/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar una persona de la base de datos")
    public void eliminarPersona(@PathVariable Long id){
        iPersonasService.eliminarPersona(id);
    }

    @GetMapping("/personas/genero/{genero}")
    @Operation(summary = "Operaci\u00f3n para obtener datos por genero")
    public List<String> getNombrePersonaByGenero(@PathVariable String genero){
        return iPersonasService.personasByGenero(genero);
    }

    @GetMapping("/personas/info/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener info de persona")
    public ResponseEntity<Object> getInfoPersona(@PathVariable Integer id){
        return iPersonasService.getInfoPersona(id);
    }

}
