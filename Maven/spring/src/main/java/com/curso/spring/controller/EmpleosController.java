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
    @Operation(summary = "Operaci\u00f3n para insertar un empleo en la base de datos")
    public ResponseEntity<Empleos> insertarEmpleo(@Valid @RequestBody Empleos request){
        return iEmpleosService.insertarEmpleo(request);
    }

    @PostMapping("/insertar-empleo/2")
    @Operation(summary = "Operaci\u00f3n para insertar un empleo en la base de datos")
    public ResponseEntity<?> insertarEmpleo2(@RequestBody EmpleoRequest request){
        return iEmpleosService.insertarEmpleo2(request);
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

    //------------------------------------------------------------------------------------------------------

    //JPQL

    //Controlador que obtiene la información de un empleo usando JPQL

    @GetMapping("/obtener-empleo/JPQL/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener un empleo de la base de datos con JPQL")
    public ResponseEntity<Object> obtenerEmpleoJPQL(@PathVariable Long id){
        return iEmpleosService.obtenerEmpleoJPQL(id);
    }

    //Controlador que actualiza la información de un empleo usando JPQL
    @PutMapping("/actualizar-empleo/JPQL")
    @Operation(summary = "Operaci\u00f3n para actualizar un empleo de la base de datos con JPQL")
    public ResponseEntity<?> actualizarEmpleoJPQL(@Valid @RequestBody EmpleoRequest request){
        return iEmpleosService.actualizarEmpleoJPQL(request);
    }

    //Controlador que elimina un empleo de la base de datos usando JPQL
    @DeleteMapping("/eliminar-empleo/JPQL/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar un empleo de la base de datos con JPQL")
    public boolean eliminarEmpleoJPQL(@PathVariable Long id){
        return iEmpleosService.eliminarEmpleoJPQL(id);
    }

    //------------------------------------------------------------------------------------------------------

    //NativeQuery

    //Controlador que obtiene la información de un empleo usando NativeQuery

    @GetMapping("/obtener-empleo/native/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener un empleo de la base de datos con nativeQuery")
    public ResponseEntity<Object> obtenerEmpleoQueryNative(@PathVariable Integer id){
        return iEmpleosService.obtenerEmpleoQueryNative(id);
    }

    //Controlador que inserta un nuevo empleo en la base de datos usando NativeQuery
    @PostMapping("/insertar-empleo/native")
    @Operation(summary = "Operaci\u00f3n para insertar un empleo en la base de datos con nativeQuery")
    public ResponseEntity<?> insertarEmpleoQueryNative(@Valid @RequestBody EmpleoRequest request){
        return iEmpleosService.insertarEmpleoQueryNative(request);
    }

    //Controlador que actualiza la información de un empleo usando NativeQuery
    @PutMapping("/actualizar-empleo/native")
    @Operation(summary = "Operaci\u00f3n para actualizar un empleo en la base de datos con nativeQuery")
    public ResponseEntity<?> actualizarEmpleoQueryNative(@Valid @RequestBody EmpleoRequest request){
        return iEmpleosService.actualizarEmpleoQueryNative(request);
    }

    //Controlador que elimina un empleo de la base de datos usando NativeQuery
    @DeleteMapping("/eliminar-empleo/native/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar un empleo de la base de datos con nativeQuery")
    public boolean eliminarEmpleoQueryNative(@PathVariable Long id){
        return iEmpleosService.eliminarEmpleoQueryNative(id);
    }


}
