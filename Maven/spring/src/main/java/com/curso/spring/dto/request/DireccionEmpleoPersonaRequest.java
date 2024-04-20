package com.curso.spring.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionEmpleoPersonaRequest {
    private DireccionRequest direccionRequest;
    private EmpleoRequest empleoRequest;
    private PersonaRequest personaRequest;
}
