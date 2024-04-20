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

    @PostMapping("/insertar-direccion/2")
    @Operation(summary = "Operaci\u00f3n para insertar una direcci\u00f3n en la base de datos")
    public ResponseEntity<?> insertarDireccion2(@RequestBody DireccionRequest request){
        return iDireccionesService.insertarDireccion2(request);
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

    @GetMapping("/buscar-direccion/{id}")
    @Operation(summary = "Operaci\u00f3n para buscar una direcci\u00f3n por id en la base de datos")
    public ResponseEntity<Object> buscarDireccionId(@PathVariable Long id){
        return iDireccionesService.buscarDireccionId(id);
    }

    //------------------------------------------------------------------------------------------------------

    //JPQL

    //Controlador que obtiene la información de una dirección usando JPQL

    @GetMapping("/obtener-direccion/JPQL/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener una direcci\u00f3n de la base de datos con JPQL")
    public ResponseEntity<Object> obtenerDireccionJPQL(@PathVariable Long id){
        return iDireccionesService.obtenerDireccionJPQL(id);
    }

    //Controlador que actualiza la información de una dirección usando JPQL
    @PutMapping("/actualizar-direccion/JPQL")
    @Operation(summary = "Operaci\u00f3n para actualizar una direcci\u00f3n de la base de datos con JPQL")
    public ResponseEntity<?> actualizarDireccionJPQL(@Valid @RequestBody DireccionRequest request){
        return iDireccionesService.actualizarDireccionJPQL(request);
    }

    //Controlador que elimina una dirección de la base de datos usando JPQL
    @DeleteMapping("/eliminar-direccion/JPQL/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar un direcci\u00f3n de la base de datos con JPQL")
    public boolean eliminarDireccionJPQL(@PathVariable Long id){
        return iDireccionesService.eliminarDireccionJPQL(id);
    }

    //------------------------------------------------------------------------------------------------------

    //NativeQuery

    //Controlador que obtiene la información de una dirección usando NativeQuery

    @GetMapping("/obtener-direccion/native/{id}")
    @Operation(summary = "Operaci\u00f3n para obtener una direcci\u00f3n de la base de datos con nativeQuery")
    public ResponseEntity<Object> obtenerDireccionQueryNative(@PathVariable Integer id){
        return iDireccionesService.obtenerDireccionQueryNative(id);
    }

    //Controlador que inserta una nueva dirección en la base de datos usando NativeQuery
    @PostMapping("/insertar-direccion/native")
    @Operation(summary = "Operaci\u00f3n para insertar una direcci\u00f3n en la base de datos con nativeQuery")
    public ResponseEntity<?> insertarDireccionQueryNative(@Valid @RequestBody DireccionRequest request){
        return iDireccionesService.insertarDireccionQueryNative(request);
    }

    //Controlador que actualiza la información de una dirección usando NativeQuery
    @PutMapping("/actualizar-direccion/native")
    @Operation(summary = "Operaci\u00f3n para actualizar una direcci\u00f3n en la base de datos con nativeQuery")
    public ResponseEntity<?> actualizarDireccionQueryNative(@Valid @RequestBody DireccionRequest request){
        return iDireccionesService.actualizarDireccionQueryNative(request);
    }

    //Controlador que elimina una dirección de la base de datos usando NativeQuery
    @DeleteMapping("/eliminar-direccion/native/{id}")
    @Operation(summary = "Operaci\u00f3n para eliminar una direcci\u00f3n de la base de datos con nativeQuery")
    public boolean eliminarDireccionQueryNative(@PathVariable Long id){
        return iDireccionesService.eliminarDireccionQueryNative(id);
    }
}
