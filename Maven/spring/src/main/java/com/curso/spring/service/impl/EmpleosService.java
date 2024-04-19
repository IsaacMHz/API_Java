package com.curso.spring.service.impl;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import com.curso.spring.repository.EmpleosRepository;
import com.curso.spring.service.IEmpleosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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


}
