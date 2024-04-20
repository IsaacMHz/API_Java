package com.curso.spring.service.impl;

import com.curso.spring.dto.request.DireccionEmpleoPersonaRequest;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.repository.PersonasRepository;
import com.curso.spring.response.DatosPersonaResponse;
import com.curso.spring.service.IPersonasService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasRepository personasRepository;
    @Autowired
    private DireccionesService direccionesService;
    @Autowired
    private EmpleosService empleosService;

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

    @Override
    public Personas buscarPersonaPorId(Long id) {
        Optional<Personas> datosPersona = personasRepository.findById(id);
        return datosPersona.get();
    }

    @Override
    public ResponseEntity<Object> updatePersona(PersonaRequest request) {

        ResponseEntity<Object> response = null;

        Optional<Personas> existePersona = personasRepository.findById(request.getIdPersona());

        if(existePersona.isPresent()) {

            Personas personas = new Personas();
            personas.setPersonaId(request.getIdPersona());
            personas.setNombre(request.getNombre());
            personas.setEdad(request.getEdad());
            personas.setGenero(request.getGenero());
            //personas.setDireccionId(request.getIdDireccion());
            //personas.setEmpleoId(request.getIdEmpleo());

            response = ResponseEntity.ok(personasRepository.save(personas));
        }
        else {
            response = ResponseEntity.status(HttpStatus.MULTI_STATUS).body("No se encontro");
        }
        return response;
    }

    @Override
    public void eliminarPersona(Long id) {
        personasRepository.deleteById(id);
    }

    @Override
    public List<String> personasByGenero(String genero) {
        return personasRepository.personasByGenero(genero);
    }

    @Override
    public ResponseEntity<Object> getInfoPersona(Integer id) {

        ResponseEntity<Object> response = null;

        try{

            Optional<DatosPersonaResponse> infoPersona = Optional.ofNullable(personasRepository.getInfoPersonas(id));

            if(infoPersona.isPresent()) {
                response = ResponseEntity.ok(infoPersona.get());
            }
            else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron los datos de la persona con ID: "+ id);
            }

        }catch (Exception e){
            log.error("Error en metodo getInfoPersona: " + e.getMessage());
        }
        return response ;
    }

    @Transactional
    @Override
    public ResponseEntity<?> savePersonaNativa(PersonaRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = personasRepository.savePersonaNativa(request);

            if (result>0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un error al insertar");
            }

        }catch (Exception e){
            log.error("Error " + e.getMessage());
        }
        return response;
    }

    @Transactional
    @Override
    public ResponseEntity<?> actualizarPersonaNative(PersonaRequest request) throws Exception {

        ResponseEntity<?> response = null;

        try{
            log.info("Request guardar: " + request);
            Integer result = personasRepository.actualizarPersonaNative(request);

            if (result>0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un error al insertar");
            }
        }catch (Exception e){
            throw new Exception("Error en metodo actualizarPersonaNative: " + e.getMessage());
        }

        return response;
    }

    //Metodo para eliminar una persona
    @Transactional
    @Override
    public boolean deletePersonaNative(Long id) {

        boolean response = false;

        try{
            personasRepository.deletePersonaNative(id);
            response =true;
        }catch (Exception e){
            log.error("Error " + e.getMessage());
        }

        return response;
    }

    public ResponseEntity<?> guardarPersona2(PersonaRequest request,Long direccionId, Long empleoId) {

        Personas nuevaPersona = new Personas();
        nuevaPersona.setNombre(request.getNombre());
        nuevaPersona.setEdad(request.getEdad());
        nuevaPersona.setGenero(request.getGenero());
        nuevaPersona.setDireccionId(direccionId);
        nuevaPersona.setEmpleoId(empleoId);
        personasRepository.save(nuevaPersona);

        return ResponseEntity.ok("Operaci\u00f3n exitosa");
    }

    @Override
    public ResponseEntity<?> insertarPersonaEmpleoDireccion(DireccionEmpleoPersonaRequest request) {

        Long direccionId = direccionesService.guardarDireccion(request.getDireccionRequest());
        Long empleoId = empleosService.guardarEmpleo(request.getEmpleoRequest());
        return guardarPersona2(request.getPersonaRequest(),direccionId,empleoId);

    }
}
