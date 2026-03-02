package com.segurosbolivar.polizas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.segurosbolivar.polizas.domain.model.Riesgo;
import java.util.List;

public interface RiesgoRepository 
        extends JpaRepository<Riesgo, Long> {

    List<Riesgo> findByPolizaId(Long polizaId);
}