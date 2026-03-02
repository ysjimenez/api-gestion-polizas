package com.segurosbolivar.polizas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.segurosbolivar.polizas.domain.model.Poliza;
import com.segurosbolivar.polizas.domain.model.EstadoPoliza;
import com.segurosbolivar.polizas.domain.model.TipoPoliza;
import java.util.List;

public interface PolizaRepository 
        extends JpaRepository<Poliza, Long> {

    List<Poliza> findByTipoAndEstado(
            TipoPoliza tipo,
            EstadoPoliza estado);
}