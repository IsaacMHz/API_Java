package com.curso.spring.service.impl;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.model.Empleos;
import com.curso.spring.repository.EmpleosRepository;
import com.curso.spring.response.DatosEmpleosResponse;
import com.curso.spring.response.DatosPersonaResponse;
import com.curso.spring.service.IEmpleosService;
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
public class EmpleosService implements IEmpleosService {
    @Autowired
    private EmpleosRepository empleosRepository;
    @Override
    public List<Empleos> mostrarTodosEmpleos() {
        return empleosRepository.findAll();
    }
    @Override
    public ResponseEntity<Empleos> insertarEmpleo(Empleos request) {
        return ResponseEntity.ok(empleosRepository.save(request));
    }

    @Override
    public ResponseEntity<?> insertarEmpleo2(EmpleoRequest empleoRequest) {

        Empleos nuevoEmpleo = new Empleos();
        nuevoEmpleo.setTitulo(empleoRequest.getTitulo());
        nuevoEmpleo.setEmpresa(empleoRequest.getEmpresa());
        nuevoEmpleo.setSalario(empleoRequest.getSalario());
        Empleos empleoGuardado = empleosRepository.save(nuevoEmpleo);

        return ResponseEntity.ok(empleoGuardado.getEmpleo_id());
    }

    public Long guardarEmpleo(EmpleoRequest empleoRequest) {

        Empleos nuevoEmpleo = new Empleos();
        nuevoEmpleo.setTitulo(empleoRequest.getTitulo());
        nuevoEmpleo.setEmpresa(empleoRequest.getEmpresa());
        nuevoEmpleo.setSalario(empleoRequest.getSalario());
        Empleos empleoGuardado = empleosRepository.save(nuevoEmpleo);

        return empleoGuardado.getEmpleo_id();
    }


    @Override
    public ResponseEntity<Object> actualizarEmpleo(EmpleoRequest request) {

        ResponseEntity<Object> response = null;

        Optional<Empleos> existeEmpleo = empleosRepository.findById(request.getEmpleo_id());

        if(existeEmpleo.isPresent()) {

            Empleos empleoActualizado = new Empleos();
            empleoActualizado.setEmpleo_id(request.getEmpleo_id());
            empleoActualizado.setTitulo(request.getTitulo());
            empleoActualizado.setEmpresa(request.getEmpresa());
            empleoActualizado.setSalario(request.getSalario());

            response = ResponseEntity.ok(empleosRepository.save(empleoActualizado));
        }
        else{
            response = ResponseEntity.badRequest().body("El Id no de encontr\u00f3");
        }

        return response;

    }

    @Override
    public ResponseEntity<Object> eliminarEmpleo(Long id) {

        ResponseEntity<Object> response = null;

        Optional<Empleos> existeEmpleo = empleosRepository.findById(id);

        if(existeEmpleo.isPresent()){
            empleosRepository.deleteById(id);
            response = ResponseEntity.ok("El empleo ha sido eliminado exitosamente");
        }
        else {
            response = ResponseEntity.badRequest().body("El id no se encontr\u00f3");
        }
        return response;
    }

    @Override
    public ResponseEntity<Object> mostrarEmpleoId(Long id) {

        ResponseEntity<Object> response = null;

        Optional<Empleos> existeEmpleo = empleosRepository.findById(id);

        if(existeEmpleo.isPresent()){
            response = ResponseEntity.ok(empleosRepository.findById(id));
        }
        else {
            response = ResponseEntity.badRequest().body("El id no se encontr\u00f3");
        }

        return response ;
    }

    //---------------------------------------------------------------------------------------------------------

    //JPQL

    //Implementación realizada para obtener toda la información de un empleo mediante JPQL, se usó la clase Empleos
    @Override
    public ResponseEntity<Object> obtenerEmpleoJPQL(Long id) {

        ResponseEntity<Object> response = null;

        try{

            Optional<DatosEmpleosResponse> infoEmpleo = Optional.ofNullable(empleosRepository.obtenerEmpleoJPQL(id));

            if(infoEmpleo.isPresent()) {
                response = ResponseEntity.ok(infoEmpleo.get());
            }
            else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron los datos de la persona con ID: "+ id);
            }

        }catch (Exception e){
            log.error("Error en metodo obtenerEmpleoJPQL: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para actualizar la información de un empleo mediante JPQL, se usó la clase Empleos
    @Transactional
    @Override
    public ResponseEntity<?> actualizarEmpleoJPQL(EmpleoRequest request) {
        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = empleosRepository.actualizarEmpleoJPQL(request);

            if(result > 0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurri\uf003 un erro al actualizar");
            }

        }catch (Exception e){
            log.info("Error en el metodo actualizarEmpleoJPQL: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para eliminar un empleo de la base de datos mediante JPQL, se uso la clase Empleos
    @Transactional
    @Override
    public boolean eliminarEmpleoJPQL(Long id) {
        boolean response = false;

        try {
            empleosRepository.eliminarEmpleoJPQL(id);
            response = true;
        }
        catch (Exception e){
            log.info("Error en el metodo eliminarEmpleoJPQL: " + e.getMessage());
        }

        return response;
    }

    //--------------------------------------------------------------------------------------------------------

    //NativeQuery

    //Implementación realizada para obtener toda la información de un empleo mediante NativeQuery, se usó la entidad empleos
    @Override
    public ResponseEntity<Object> obtenerEmpleoQueryNative(Integer id) {

        ResponseEntity<Object> response = null;

        try{

            Optional<DatosEmpleosResponse> infoEmpleo = Optional.ofNullable(empleosRepository.obtenerEmpleoQueryNative(id));

            if(infoEmpleo.isPresent()) {
                response = ResponseEntity.ok(infoEmpleo.get());
            }
            else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron los datos de la persona con ID: "+ id);
            }

        }catch (Exception e){
            log.error("Error en metodo obtenerEmpleoQueryNative: " + e.getMessage());
        }

        return response;
    }

    //Implementación realizada para insertar un nuevo empleo en la base de datos mediante NativeQuery, se usó la entidad empleos
    @Transactional
    @Override
    public ResponseEntity<?> insertarEmpleoQueryNative(EmpleoRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = empleosRepository.insertarEmpleoQueryNative(request);

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

    //Implementación realizada para actualizar la información de un empleo mediante NativeQuery, se usó la entidad empleos
    @Transactional
    @Override
    public ResponseEntity<?> actualizarEmpleoQueryNative(EmpleoRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar: " + request);
            Integer result = empleosRepository.actualizarEmpleoQueryNative(request);

            if(result > 0){
                response = ResponseEntity.ok("Guardado exitosamente");
            }
            else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurri\uf003 un erro al insertar");
            }

        }catch (Exception e){
            log.info("Error en el metodo actualizarEmpleoQueryNative: " + e.getMessage());
        }

        return response;
    }

    //Consulta realizada para eliminar un empleo de la base de datos mediante NativeQuery, se usó la entidad empleos
    @Transactional
    @Override
    public boolean eliminarEmpleoQueryNative(Long id) {

        boolean response = false;

        try {
            empleosRepository.eliminarEmpleoQueryNative(id);
            response = true;
        }
        catch (Exception e){
            log.info("Error en el metodo eliminarEmpleoQueryNative: " + e.getMessage());
        }

        return response;
    }
}
