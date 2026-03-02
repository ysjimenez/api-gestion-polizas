package com.segurosbolivar.polizas.domain.service;

import com.segurosbolivar.polizas.domain.model.EstadoPoliza;
import com.segurosbolivar.polizas.domain.model.Poliza;
import com.segurosbolivar.polizas.domain.model.TipoPoliza;
import com.segurosbolivar.polizas.exception.BusinessException;

public class PolizaDomainService {

    public void renovar(Poliza poliza) {

        if (poliza.getEstado() == EstadoPoliza.CANCELADA) {
            throw new BusinessException("No se puede renovar una póliza cancelada");
        }

        double nuevoCanon = poliza.getCanonMensual() * (1 + poliza.getPorcentajeIPC());

        poliza.setCanonMensual(nuevoCanon);
        poliza.recalcularPrima();
        poliza.setEstado(EstadoPoliza.RENOVADA);
    }

    public void validarAgregarRiesgo(Poliza poliza) {

        if (poliza.getTipo() == TipoPoliza.INDIVIDUAL &&
                !poliza.getRiesgos().isEmpty()) {

            throw new BusinessException("Individual solo puede tener un riesgo");
        }
    }
}