package com.curso.spring.service;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDireccionesService {
    List<Direcciones> obtenerDirecciones();

    ResponseEntity<Direcciones> insertarDireccion(Direcciones request);

    ResponseEntity<?> insertarDireccion2(DireccionRequest direccionRequest);

    ResponseEntity<Object> actualizarDireccion(DireccionRequest request);

    ResponseEntity<Object> eliminarDireccion(Long id);

    ResponseEntity<Object> buscarDireccionId(Long id);

    //--------------------------------------------------------------------

    //JPQL
    ResponseEntity<Object> obtenerDireccionJPQL(Long id);

    ResponseEntity<?> actualizarDireccionJPQL(DireccionRequest request);

    boolean eliminarDireccionJPQL(Long id);

    //--------------------------------------------------------------------

    //NativeQuery
    ResponseEntity<Object> obtenerDireccionQueryNative(Integer id);

    ResponseEntity<?> insertarDireccionQueryNative(DireccionRequest request);

    ResponseEntity<?> actualizarDireccionQueryNative(DireccionRequest request);

    boolean eliminarDireccionQueryNative(Long id);
}
