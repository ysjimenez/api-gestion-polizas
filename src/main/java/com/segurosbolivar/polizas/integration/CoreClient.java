package com.segurosbolivar.polizas.integration;

import org.springframework.stereotype.Component;

@Component
public class CoreClient {

    public void notificar(String evento, Long polizaId) {
        System.out.println(
                "Evento enviado al CORE: " 
                + evento + " polizaId=" + polizaId);
    }
}