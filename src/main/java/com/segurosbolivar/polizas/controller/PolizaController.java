package com.segurosbolivar.polizas.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.segurosbolivar.polizas.application.PolizaApplicationService;
import com.segurosbolivar.polizas.dto.PolizaResponse;
import com.segurosbolivar.polizas.dto.RiesgoResponse;
import com.segurosbolivar.polizas.dto.CrearRiesgoRequest;

@RestController
@RequestMapping("/api/v1/polizas")
public class PolizaController {

    private final PolizaApplicationService service;

    public PolizaController(PolizaApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<PolizaResponse> listar(
            @RequestParam String tipo,
            @RequestParam String estado) {

        return service.listar(tipo, estado);
    }

    @GetMapping("/{id}/riesgos")
    public List<RiesgoResponse> listarRiesgos(@PathVariable Long id) {
        return service.listarRiesgos(id);
    
    }
    
    @PostMapping("/{id}/renovar")
    public PolizaResponse renovar(@PathVariable Long id) {
        return service.renovar(id);
    }

    @PostMapping("/{id}/cancelar")
    public PolizaResponse cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }

    @PostMapping("/{id}/riesgos")
    public PolizaResponse agregarRiesgo(
            @PathVariable Long id,
            @RequestBody @Valid CrearRiesgoRequest request) {

        return service.agregarRiesgo(id, request.getDescripcion());
    }
}