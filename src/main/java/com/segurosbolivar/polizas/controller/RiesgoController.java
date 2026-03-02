package com.segurosbolivar.polizas.controller;

import org.springframework.web.bind.annotation.*;
import com.segurosbolivar.polizas.application.PolizaApplicationService;
import com.segurosbolivar.polizas.dto.PolizaResponse;

@RestController
@RequestMapping("/api/v1/riesgos")
public class RiesgoController {

    private final PolizaApplicationService service;

    public RiesgoController(PolizaApplicationService service) {
        this.service = service;
    }

    @PostMapping("/{id}/cancelar")
    public PolizaResponse cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }
   
}