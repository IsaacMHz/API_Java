package com.curso.spring.service.impl;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.repository.PersonasRepository;
import com.curso.spring.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Personas> findAllPersons() {
        return personasRepository.findAll();
    }

    @Override
    public ResponseEntity<Personas> guardarPersona(Personas personas) {
        return ResponseEntity.ok(personasRepository.save(personas));
    }

    @Override
    public ResponseEntity<Personas> guardarPersona2(PersonaRequest request) {

        Personas personas = new Personas();
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        personas.setDireccionId(request.getIdDireccion());
        personas.setEmpleoId(request.getIdEmpleo());

        return ResponseEntity.ok(personasRepository.save(personas));
    }
}
