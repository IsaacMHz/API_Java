package com.curso.spring.controller;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.service.IDireccionesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/direcciones")
@Tag(name = "Direcciones")
public class DireccionesController {

    @Autowired
    private IDireccionesService iDireccionesService;
    @GetMapping("/obtener-direcciones")
    @Operation(summary = "Operaci\u00f3n para mostrar todas las direcciones que hay en la base de datos")
    public List<Direcciones> obtenerDirecciones(){
        return iDireccionesService.obtenerDirecciones();
    }

    @PostMapping("/insertar-direccion")
    @Operation(summary = "Operaci\u00f3n para insertar una direcci\u00f3n en la base de datos")
    public ResponseEntity<Direcciones> insertarDireccion(@Valid @RequestBody Direcciones request){
        return iDireccionesService.insertarDireccion(request);
    }

    @PutMapping("/actualizar-direccion")
    @Operation(summary = "Operaci\u00f3n para actualizar una direcci\u00f3n de la base de datos")
    public ResponseEntity<Object> actualizarDireccion(@Valid @RequestBody DireccionRequest request){
        return iDireccionesService.actualizarDireccion(request);
    }

    @DeleteMapping("/eliminar-direccion/{id}")
    @Operation(summary = "Operaci\u00f3n para actualizar una direcci\u00f3n de la base de datos")
    public ResponseEntity<Object> eliminarDireccion(@PathVariable Long id){
        return iDireccionesService.eliminarDireccion(id);
    }

    @GetMapping("/buscar-empleo/{id}")
    @Operation(summary = "Operaci\u00f3n para buscar una direcci\u00f3n por id en la base de datos")
    public ResponseEntity<Object> buscarDireccionId(@PathVariable Long id){
        return iDireccionesService.buscarDireccionId(id);
    }


}
