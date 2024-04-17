package com.curso.spring.controller;

import com.curso.spring.dto.CirculoDto;
import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.ICirculoService;
import com.curso.spring.service.IRectanguloService;
import com.curso.spring.service.ITrianguloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("figuras")
@Slf4j
@CrossOrigin
@Tag(name = "Figuras")
public class FigurasController {

    @Autowired
    private IRectanguloService iRectanguloService;

    @Autowired
    private ITrianguloService iTrianguloService;

    @Autowired
    private ICirculoService iCirculoService;

    //Rectangulo
    @GetMapping("/area-rectangulo/{base}/{altura}")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un rect\u00e1ngulo a trav\u00e9s de la url")
    //@RequestMapping(method = RequestMethod.GET, value = "/area-rectangulo/{base}/{altura}")
    public double CalcularAreaRectanguloUrl(@PathVariable @Schema(description = "Base del rectangulo", example = "20.46") double base, @PathVariable @Schema(description = "Altura del rectangulo", example = "10.57") double altura){
        return base * altura;
    }

    @PostMapping("/area-rectangulo")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un rect\u00e1ngulo pasando un objeto")
    public double CalculateAreaRectangulo(@Valid @RequestBody RectanguloDto request){
        return iRectanguloService.CalcularAreaRectangulo(request);
    }

    //Triangulo
    @GetMapping("/area-tringulo/{base}/{altura}")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un tri\u00e1ngulo a trav\u00e9s de la url")
    public double CalcularAreaTrianguloUrl(@PathVariable @Schema(description = "Base del triangulo", example = "20.46") double base, @PathVariable @Schema(description = "Altura del tringualo", example = "10.57") double altura){
        return base * altura / 2;
    }

    @PostMapping("/area-triangulo")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un tri\u00e1ngulo pasando un objeto")
    public double CalcularAreaTriangulo(@Valid @RequestBody TrianguloDto request){
        return iTrianguloService.CalcularAreaTriangulo(request);
    }

    //Circulo
    @GetMapping("/area-circulo/{radio}")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un c\u00edrculo a trav\u00e9s de la url")
    public double CalcularAreaCirculoUrl(@PathVariable @Schema(description = "Radio del circulo", example = "20.46") double radio){
        return Math.PI * Math.pow(radio,2);
    }

    @PostMapping("/area-circulo")
    @Operation(summary = "Operaci\u00f3n para mostrar el \u00e1rea de un c\u00edrculo pasando un objeto")
    public double CalcularAreaCirculo(@Valid @RequestBody CirculoDto request){
        return iCirculoService.CalcularAreaCirculo(request);
    }

}
