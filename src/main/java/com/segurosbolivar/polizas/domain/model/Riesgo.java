package com.segurosbolivar.polizas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.EnumType;

@Entity
@Data

public class Riesgo {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoRiesgo estado = EstadoRiesgo.ACTIVO;

    @ManyToOne
    @JoinColumn(name = "poliza_id")
    @JsonIgnore
    private Poliza poliza;
}
