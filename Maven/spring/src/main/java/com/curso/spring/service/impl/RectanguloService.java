package com.curso.spring.service.impl;

import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.service.IRectanguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class RectanguloService implements IRectanguloService {

    @Override
    public double CalcularAreaRectangulo(RectanguloDto request){
        return request.getBase() * request.getAltura();
    }
}
