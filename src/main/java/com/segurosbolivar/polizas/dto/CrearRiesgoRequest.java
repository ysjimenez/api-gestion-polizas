package com.segurosbolivar.polizas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearRiesgoRequest {

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;
}