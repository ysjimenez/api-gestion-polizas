package com.segurosbolivar.polizas.integration;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public void enviarCorreo(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }

    public void enviarSMS(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}