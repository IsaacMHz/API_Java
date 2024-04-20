package com.curso.spring.service;

import com.curso.spring.dto.request.DireccionEmpleoPersonaRequest;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPersonasService {
    List<Personas> findAllPersons();
    ResponseEntity<Personas> guardarPersona(Personas personas);
    ResponseEntity<Personas> guardarPersona2(PersonaRequest personas);

    Personas buscarPersonaPorId(Long id);
    ResponseEntity<Object> updatePersona(PersonaRequest request);

    void eliminarPersona(Long id);

    List<String> personasByGenero(String genero);

    ResponseEntity<Object> getInfoPersona(Integer id);

    ResponseEntity<?> savePersonaNativa(PersonaRequest request);

    ResponseEntity<?> actualizarPersonaNative(PersonaRequest request) throws Exception;
    boolean deletePersonaNative(Long id);

    ResponseEntity<?> insertarPersonaEmpleoDireccion(DireccionEmpleoPersonaRequest request);
}
