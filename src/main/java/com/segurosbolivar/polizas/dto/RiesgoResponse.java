package com.segurosbolivar.polizas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RiesgoResponse {

    private Long id;
    private String descripcion;
    private String estado;
}