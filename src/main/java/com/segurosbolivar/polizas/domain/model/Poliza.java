package com.segurosbolivar.polizas.domain.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
import lombok.Data;

@Entity
@Data

public class Poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPoliza tipo;

    @Enumerated(EnumType.STRING)
    private EstadoPoliza estado = EstadoPoliza.ACTIVA;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private double canonMensual;
    private Double prima;
    private Double porcentajeIPC;   

    private String tomador;
    private String asegurado;
    private String beneficiario;

    @OneToMany(mappedBy = "poliza", cascade = CascadeType.ALL)
    private List<Riesgo> riesgos = new ArrayList<>();

    public void recalcularPrima() {
        long meses = ChronoUnit.MONTHS.between(fechaInicio, fechaFin);
        this.prima = canonMensual * meses;
    }
}