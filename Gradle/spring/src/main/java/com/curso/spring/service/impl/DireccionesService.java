package com.curso.spring.service.impl;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.model.Personas;
import com.curso.spring.repository.DireccionesRepository;
import com.curso.spring.response.DatosDireccionesResponse;
import com.curso.spring.service.IDireccionesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DireccionesService implements IDireccionesService {

    @Autowired
    private DireccionesRepository direccionesRepository;
    @Override
    public List<Direcciones> obtenerDirecciones() {
        return direccionesRepository.findAll();
    }

    @Override
    public ResponseEntity<Direcciones> insertarDireccion(Direcciones request) {
        return ResponseEntity.ok(direccionesRepository.save(request));
    }

    @Override
    public ResponseEntity<?> insertarDireccion2(DireccionRequest direccionRequest) {

        Direcciones nuevaDireccion = new Direcciones();
        nuevaDireccion.setCalle(direccionRequest.getCalle());
        nuevaDireccion.setCiudad(direccionRequest.getCiudad());
        nuevaDireccion.setEstado(direccionRequest.getEstado());
        nuevaDireccion.setCodigo_postal(direccionRequest.getCodigo_postal());
        Direcciones direccionGuardada = direccionesRepository.save(nuevaDireccion);

        return ResponseEntity.ok(direccionGuardada.getDireccion_id());
    }

    public Long guardarDireccion(DireccionRequest direccionRequest) {

        Direcciones nuevaDireccion = new Direcciones();
        nuevaDireccion.setCalle(direccionRequest.getCalle());
        nuevaDireccion.setCiudad(direccionRequest.getCiudad());
        nuevaDireccion.setEstado(direccionRequest.getEstado());
        nuevaDireccion.setCodigo_postal(direccionRequest.getCodigo_postal());
        Direcciones direccionGuardada = direccionesRepository.save(nuevaDireccion);

        return direccionGuardada.getDireccion_id();
    }

    @Override
    public ResponseEntity<Object> actualizarDireccion(DireccionRequest request) {
        ResponseEntity<Object> response = null;

        Optional<Direcciones> existeDireccion = direccionesRepository.findById(request.getDireccion_id());

        if (existeDireccion.isPresent()){
            Direcciones direccionActualizada = new Direcciones();
            direccionActualizada.setDireccion_id(request.getDireccion_id());
            direccionActualizada.setCalle(request.getCalle());
            direccionActualizada.setCiudad(request.getCiudad());
            direccionActualizada.setEstado(request.getEstado());
            direccionActualizada.setCodigo_postal(request.getCodigo_postal());

            response = ResponseEntity.ok(direccionesRepository.save(direccionActualizada));
        }
        else {
            response = ResponseEntity.badRequest().body("El id no se encontr\u00f3");
        }

        return response;
    }

    @Override
    public ResponseEntity<Object> eliminarDireccion(Long id) {
        ResponseEntity<Object> response = null;
        Optional<Direcciones> existeDireccion = direccionesRepository.findById(id);

        if(existeDireccion.isPresent()) {
            direccionesRepository.deleteById(id);
            response = ResponseEntity.ok("La direcci\u00f3n ha sido eliminada exitosamente");
        }
        else {
            response = ResponseEntity.badRequest().body("El id no se encontr\u00f3");
        }

        return response;
    }

    @Override
    public ResponseEntity<Object> buscarDireccionId(Long id) {

        ResponseEntity<Object> response = null;

        Optional<Direcciones> existeDireccion = direccionesRepository.findById(id);

        if (existeDireccion.isPresent()){
            response = ResponseEntity.ok(direccionesRepository.findById(id));
        }
        else {
            response = ResponseEntity.badRequest().body("El id no se encontr\u00f3");
        }

        return response;
    }

    //---------------------------------------------------------------------------------------------------------

    //JPQL

    //Implementación realizada para obtener toda la información de un dirección mediante JPQL, se usó la clase Direcciones
    @Override
    public ResponseEntity<Object> obtenerDireccionJPQL(Long id) {

        ResponseEntity<Object> response = null;

        try{

            Optional<DatosDireccionesResponse> infoDireccion = Optional.ofNullable(direccionesRepository.obtenerDireccionJPQL(id));

            if(infoDireccion.isPresent()) {
                response = ResponseEntity.ok(infoDireccion.get());
            }
            else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron los datos de la persona con ID: "+ id);
            }

        }catch (Exception e){
            log.error("Error en metodo obtenerDireccionJPQL: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para actualizar la información de una dirección mediante JPQL, se usó la clase Direcciones
    @Transactional
    @Override
    public ResponseEntity<?> actualizarDireccionJPQL(DireccionRequest request) {
        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = direccionesRepository.actualizarDireccionJPQL(request);

            if(result > 0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurri\uf003 un error al actualizar");
            }

        }catch (Exception e){
            log.info("Error en el metodo actualizarDireccionJPQL: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para eliminar una dirección de la base de datos mediante JPQL, se usó la clase Direcciones
    @Transactional
    @Override
    public boolean eliminarDireccionJPQL(Long id) {
        boolean response = false;

        try {
            direccionesRepository.eliminarDireccionJPQL(id);
            response = true;
        }
        catch (Exception e){
            log.info("Error en el metodo eliminarDireccionJPQL: " + e.getMessage());
        }

        return response;
    }

    //--------------------------------------------------------------------------------------------------------

    //NativeQuery

    //Implementación realizada para obtener toda la información de una dirección mediante NativeQuery, se usó la entidad direcciones
    @Override
    public ResponseEntity<Object> obtenerDireccionQueryNative(Integer id) {

        ResponseEntity<Object> response = null;

        try{

            Optional<DatosDireccionesResponse> infoDireccion = Optional.ofNullable(direccionesRepository.obtenerDireccionQueryNative(id));

            if(infoDireccion.isPresent()) {
                response = ResponseEntity.ok(infoDireccion.get());
            }
            else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron los datos de la persona con ID: "+ id);
            }

        }catch (Exception e){
            log.error("Error en metodo obtenerDireccionQueryNative: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para insertar una nueva dirección en la base de datos mediante NativeQuery, se usó la entidad direcciones
    @Transactional
    @Override
    public ResponseEntity<?> insertarDireccionQueryNative(DireccionRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = direccionesRepository.insertarDireccionQueryNative(request);

            if(result > 0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurri\uf003 un erro al insertar");
            }

        }catch (Exception e){
            log.info("Error en el metodo insertarEmpleoQueryNative: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para actualizar la información de una dirección mediante NativeQuery, se usó la entidad direcciones
    @Transactional
    @Override
    public ResponseEntity<?> actualizarDireccionQueryNative(DireccionRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = direccionesRepository.actualizarDireccionQueryNative(request);

            if(result > 0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurri\uf003 un erro al insertar");
            }

        }catch (Exception e){
            log.info("Error en el metodo actualizarDireccionQueryNative: " + e.getMessage());
        }

        return response;
    }

    //Consulta realizada para eliminar una dirección de la base de datos mediante NativeQuery, se usó la entidad direcciones
    @Transactional
    @Override
    public boolean eliminarDireccionQueryNative(Long id) {

        boolean response = false;

        try {
            direccionesRepository.eliminarDireccionQueryNative(id);
            response = true;
        }
        catch (Exception e){
            log.info("Error en el metodo eliminarDireccionQueryNative: " + e.getMessage());
        }

        return response;
    }

}
