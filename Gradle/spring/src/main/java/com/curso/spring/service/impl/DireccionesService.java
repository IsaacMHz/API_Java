package com.curso.spring.service.impl;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.repository.DireccionesRepository;
import com.curso.spring.service.IDireccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
}
