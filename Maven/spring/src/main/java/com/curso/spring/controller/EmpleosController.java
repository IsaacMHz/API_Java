package com.curso.spring.controller;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import com.curso.spring.service.IEmpleosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empleos/maven")
@Tag(name = "Empleos")
public class EmpleosController {

    @Autowired
    private IEmpleosService iEmpleosService;
    @GetMapping("/obtener-empleos")
    @Operation(summary = "Operaci\u00f3n para mostrar todos los empleos que hay en la base de datos" )
    public List<Empleos> obtenerEmpleos(){
        return iEmpleosService.mostrarTodosEmpleos();
    }

    @PostMapping("/insertar-empleo")
    @Operation(summary = "Operaci\u00f3n para insertar un empleo a la base de datos")
    public ResponseEntity<Empleos> insertarEmpleo(@Valid @RequestBody Empleos request){
        return iEmpleosService.insertarEmpleo(request);
    }

    @PutMapping("/actualizar-empleo")
    @Operation(summary = "Operaci\u00f3n para actualizar un empleo de la base de datos")
    public ResponseEntity<Object> actualizarEmpleo(@Valid @RequestBody EmpleoRequest request){
        return iEmpleosService.actualizarEmpleo(request);
    }

    @DeleteMapping("/eliminar-empleo/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar un empleo de la base de datos")
    public ResponseEntity<Object> eliminarEmpleo(@PathVariable Long id){
        return iEmpleosService.eliminarEmpleo(id);
    }

    @GetMapping("/buscar-empleo/{id}")
    @Operation(summary = "Operaci\u00f3n para buscar un empleo por id en la base de datos")
    public ResponseEntity<Object> buscarEmpleoId(@PathVariable Long id){
        return iEmpleosService.mostrarEmpleoId(id);
    }

}
