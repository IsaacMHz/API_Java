package com.curso.spring.service;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDireccionesService {
    List<Direcciones> obtenerDirecciones();

    ResponseEntity<Direcciones> insertarDireccion(Direcciones request);

    ResponseEntity<Object> actualizarDireccion(DireccionRequest request);

    ResponseEntity<Object> eliminarDireccion(Long id);

    ResponseEntity<Object> buscarDireccionId(Long id);
}
