package com.segurosbolivar.polizas.application;

import org.springframework.stereotype.Service;
import java.util.List;

import com.segurosbolivar.polizas.domain.model.*;
import com.segurosbolivar.polizas.domain.service.PolizaDomainService;
import com.segurosbolivar.polizas.repository.*;
import com.segurosbolivar.polizas.integration.*;
import com.segurosbolivar.polizas.dto.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class PolizaApplicationService {

    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;
    private final CoreClient coreClient;
    private final NotificationService notificationService;
    private final PolizaDomainService domainService;

    public PolizaApplicationService(
            PolizaRepository polizaRepository,
            RiesgoRepository riesgoRepository,
            CoreClient coreClient,
            NotificationService notificationService) {

        this.polizaRepository = polizaRepository;
        this.riesgoRepository = riesgoRepository;
        this.coreClient = coreClient;
        this.notificationService = notificationService;
        this.domainService = new PolizaDomainService();
    }

    /*
     * Permite obtener una lista de pólizas filtradas por tipo y estado.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */
    public List<PolizaResponse> listar(String tipo, String estado) {

        return polizaRepository.findByTipoAndEstado(
                TipoPoliza.valueOf(tipo),
                EstadoPoliza.valueOf(estado))
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /*
     * Permite renovar una póliza existente.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */
    public PolizaResponse renovar(Long id) {

        Poliza poliza = polizaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poliza no encontrada"));

        domainService.renovar(poliza);
        polizaRepository.save(poliza);

        coreClient.notificar("ACTUALIZACION", poliza.getId());
        notificationService.enviarCorreo("Poliza renovada ID: " + poliza.getId());

        return toResponse(poliza);
    }

    /*
     * Permite cancelar una póliza existente.
     * @author:Yulisa Jimenez
     * Fecha: 2026-02-01
     */
    public PolizaResponse cancelar(Long id) {

        Poliza poliza = polizaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poliza no encontrada"));

        poliza.setEstado(EstadoPoliza.CANCELADA);
        poliza.getRiesgos()
                .forEach(r -> r.setEstado(EstadoRiesgo.CANCELADO));

        polizaRepository.save(poliza);

        coreClient.notificar("ACTUALIZACION", poliza.getId());

        return toResponse(poliza);
    }
    
    /*
     * Permite obtener una lista de riesgos asociados a una póliza.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */ 
    public List<RiesgoResponse> listarRiesgos(Long polizaId) {

        Poliza poliza = polizaRepository.findById(polizaId)
                .orElseThrow(() -> new RuntimeException("Poliza no encontrada"));

        return poliza.getRiesgos()
                .stream()
                .map(r -> new RiesgoResponse(
                        r.getId(),
                        r.getDescripcion(),
                        r.getEstado().name()))
                .toList();
    }

    /* 
     * Permite agregar un nuevo riesgo a una póliza existente.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */
    public PolizaResponse agregarRiesgo(Long polizaId, String descripcion) {

        Poliza poliza = polizaRepository.findById(polizaId)
                .orElseThrow(() -> new RuntimeException("Poliza no encontrada"));

        domainService.validarAgregarRiesgo(poliza);

        Riesgo riesgo = new Riesgo();
        riesgo.setDescripcion(descripcion);
        riesgo.setPoliza(poliza);

        riesgoRepository.save(riesgo);

        coreClient.notificar("ACTUALIZACION", poliza.getId());

        return toResponse(poliza);
    }

    /*
     * Permite cancelar un riesgo existente.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */
    public void cancelarRiesgo(Long riesgoId) {

        Riesgo riesgo = riesgoRepository.findById(riesgoId)
                .orElseThrow(() -> new RuntimeException("Riesgo no encontrado"));

        riesgo.setEstado(EstadoRiesgo.CANCELADO);
        riesgoRepository.save(riesgo);

        coreClient.notificar("ACTUALIZACION",
                riesgo.getPoliza().getId());
    }

    /* 
     * Permite convertir una entidad Poliza a un DTO PolizaResponse.
     * @author:Yulisa Jiménez
     * Fecha: 2026-02-01
     */
    private PolizaResponse toResponse(Poliza poliza) {

        List<RiesgoResponse> riesgos = poliza.getRiesgos()
                .stream()
                .map(r -> new RiesgoResponse(
                        r.getId(),
                        r.getDescripcion(),
                        r.getEstado().name()))
                .toList();

        return PolizaResponse.builder()
                .id(poliza.getId())
                .tipo(poliza.getTipo().name())
                .estado(poliza.getEstado().name())
                .fechaInicio(poliza.getFechaInicio())
                .fechaFin(poliza.getFechaFin())
                .canonMensual(poliza.getCanonMensual())
                .prima(poliza.getPrima())
                .porcentajeIPC(poliza.getPorcentajeIPC())
                .tomador(poliza.getTomador())
                .asegurado(poliza.getAsegurado())
                .beneficiario(poliza.getBeneficiario())
                .riesgos(riesgos)
                .build();
    }
}