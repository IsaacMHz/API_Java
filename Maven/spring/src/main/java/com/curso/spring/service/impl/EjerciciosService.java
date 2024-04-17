package com.curso.spring.service.impl;

import com.curso.spring.service.IEjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EjerciciosService implements IEjerciciosService {
    @Override
    public List<String> getNombres() {
        log.info("Entro al metodo getNombre");

        List<String> listaNombre = new ArrayList<>();
        List<String> listaresponse = new ArrayList<>();

        listaNombre.add("Isaac");
        listaNombre.add("Carlos");
        listaNombre.add("Juan");
        listaNombre.add("Omar");

        listaresponse = listaNombre.stream()
                .filter(nombre -> nombre.toLowerCase().contains("i"))
                .collect(Collectors.toList());

        return listaresponse;
    }
}
