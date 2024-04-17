package com.curso.spring.service;

import com.curso.spring.dto.TrianguloDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ITrianguloService {
    double CalcularAreaTriangulo(TrianguloDto request);
}
