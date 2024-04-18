package com.curso.spring.service;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonasService {
    List<Personas> findAllPersons();
    ResponseEntity<Personas> guardarPersona(Personas personas);
    ResponseEntity<Personas> guardarPersona2(PersonaRequest personas);
}
