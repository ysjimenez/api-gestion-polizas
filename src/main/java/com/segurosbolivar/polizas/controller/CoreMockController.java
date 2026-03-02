package com.segurosbolivar.polizas.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/core-mock")
public class CoreMockController {

    @PostMapping("/evento")
    public ResponseEntity<String> evento(
            @RequestBody Map<String, Object> body) {
        System.out.println("Evento enviado al CORE: " + body);
        return ResponseEntity.ok("Evento registrado");
    }
}