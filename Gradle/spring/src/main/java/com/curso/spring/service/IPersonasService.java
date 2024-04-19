package com.curso.spring.service;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.response.DatosPersonaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPersonasService {
    List<Personas> findAllPersons();
    ResponseEntity<Personas> guardarPersona(Personas personas);
    ResponseEntity<Personas> guardarPersona2(PersonaRequest personas);

    Personas buscarPersonaPorId(Long id);
    ResponseEntity<Object> updatePersona(PersonaRequest request);

    void eliminarPersona(@PathVariable Long id);

    List<String> personasByGenero(String genero);

    ResponseEntity<Object> getInfoPersona(Integer id);

}
