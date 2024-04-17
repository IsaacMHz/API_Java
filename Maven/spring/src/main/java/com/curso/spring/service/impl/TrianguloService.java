package com.curso.spring.service.impl;

import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.ITrianguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class TrianguloService implements ITrianguloService {
    @Override
    public double CalcularAreaTriangulo(TrianguloDto request) {
        return request.getBase() * request.getAltura() / 2;
    }
}
