package com.curso.spring.service;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmpleosService {
    List<Empleos>mostrarTodosEmpleos();

    ResponseEntity<Empleos> insertarEmpleo(Empleos request);

    ResponseEntity<Object> actualizarEmpleo(EmpleoRequest request);

    ResponseEntity<Object> eliminarEmpleo(Long id);

    ResponseEntity<Object> mostrarEmpleoId(Long id);
}
