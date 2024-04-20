package com.curso.spring.service;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmpleosService {
    List<Empleos>mostrarTodosEmpleos();

    ResponseEntity<Empleos> insertarEmpleo(Empleos request);

    ResponseEntity<?> insertarEmpleo2(EmpleoRequest empleoRequest);

    ResponseEntity<Object> actualizarEmpleo(EmpleoRequest request);

    ResponseEntity<Object> eliminarEmpleo(Long id);

    ResponseEntity<Object> mostrarEmpleoId(Long id);

    //--------------------------------------------------------------------

    //JPQL
    ResponseEntity<Object> obtenerEmpleoJPQL(Long id);

    ResponseEntity<?> actualizarEmpleoJPQL(EmpleoRequest request);

    boolean eliminarEmpleoJPQL(Long id);

    //--------------------------------------------------------------------

    //NativeQuery
    ResponseEntity<Object> obtenerEmpleoQueryNative(Integer id);

    ResponseEntity<?> insertarEmpleoQueryNative(EmpleoRequest request);

    ResponseEntity<?> actualizarEmpleoQueryNative(EmpleoRequest request);

    boolean eliminarEmpleoQueryNative(Long id);
}
