package com.curso.spring.service.impl;

import com.curso.spring.dto.CirculoDto;
import com.curso.spring.service.ICirculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class CirculoService implements ICirculoService {
    @Override
    public double CalcularAreaCirculo(CirculoDto request){
        return Math.PI * Math.pow(request.getRadio(),2);
    }
}
