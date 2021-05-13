package com.bolivar.comunes.numeros.demo.controller;

import com.bolivar.comunes.numeros.demo.models.ObtenernumeroenpalabrasResponse;
import com.bolivar.comunes.numeros.demo.service.NumeroAPalabrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class NumeroAPalabrasController {

    @Autowired
    private NumeroAPalabrasService numberService;

    @GetMapping("/api/v1/numeros")
    public ResponseEntity<ObtenernumeroenpalabrasResponse> obtenerNumeroEnPalabras(@RequestParam BigInteger number){

        return ResponseEntity.ok(numberService.obtenerNumeroAPalabras(number));

    }

}
