package com.segurosbolivar.polizas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class PolizaResponse {

    private Long id;
    private String tipo;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double canonMensual;
    private Double prima;
    private Double porcentajeIPC;
    private String tomador;
    private String asegurado;
    private String beneficiario;
    private List<RiesgoResponse> riesgos;
}