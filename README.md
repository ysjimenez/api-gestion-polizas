# API Gestión de Pólizas Prueba Técnica

Autora: Yulisa Jiménez
Tecnología: Java 21 + Spring Boot 3.5
Base de datos:H2 (In-Memory)
Arquitectura: Arquitectura en capas con separación de dominio (DDD
simplificado)

# 1. Descripción del Proyecto

Esta API permite gestionar pólizas de arrendamiento (individuales y
colectivas), aplicando reglas de negocio reales como:

- Listado de pólizas por tipo y estado
- Renovación automática con ajuste de IPC
- Cancelación de pólizas
- Gestión de riesgos asociados
- Integración simulada con un CORE transaccional
- Seguridad básica mediante API Key

El objetivo fue construir una solución limpia, organizada y mantenible,
aplicando buenas prácticas de arquitectura y principios SOLID.

# 2. Arquitectura Implementada

Se utilizó una arquitectura en capas inspirada en Domain Driven Design
(DDD): Controller - Application - Domain - Repository -Integration

# Estructura del Proyecto

## 📂 Estructura del proyecto

```text
polizas-api
├── .mvn
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── segurosbolivar
│       │           └── polizas
│       │               ├── application
│       │               │   └── PolizaApplicationService.java
│       │               ├── config
│       │               │   └── GlobalExceptionHandler.java
│       │               ├── controller
│       │               │   ├── CoreMockController.java
│       │               │   ├── PolizaController.java
│       │               │   └── RiesgoController.java
│       │               ├── domain
│       │               │   ├── model
│       │               │   │   ├── EstadoPoliza.java
│       │               │   │   ├── EstadoRiesgo.java
│       │               │   │   ├── Poliza.java
│       │               │   │   ├── Riesgo.java
│       │               │   │   └── TipoPoliza.java
│       │               │   └── service
│       │               │       └── PolizaDomainService.java
│       │               ├── dto
│       │               │   ├── CrearRiesgoRequest.java
│       │               │   ├── PolizaResponse.java
│       │               │   └── RiesgoResponse.java
│       │               ├── exception
│       │               │   └── BusinessException.java
│       │               ├── integration
│       │               │   ├── CoreClient.java
│       │               │   └── NotificationService.java
│       │               ├── repository
│       │               │   ├── PolizaRepository.java
│       │               │   └── RiesgoRepository.java
│       │               ├── security
│       │               │   └── ApiKeyFilter.java
│       │               └── PolizasApiApplication.java
│       └── resources
│           ├── application.yml
│           └── data.sql
├── test
├── target
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

# 3. Seguridad

Se implementó un filtro personalizado:

ApiKeyFilter

Todas las APIs requieren el siguiente header:

x-api-key: 123456

Excepto: core-mock

# 4. Base de Datos

Se utiliza H2 en memoria.

Configuración:
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:segurosbolivarbd

User: 'admin'
Password: 'S3gur0s'

spring: datasource: url: jdbc:h2:mem:segurosbolivarbd jpa: hibernate: ddl-auto:
create-drop defer-datasource-initialization: true show-sql: true

# 5. Cómo Ejecutar el Proyecto

# Requisitos

- Java 21
- Maven (o usar Maven Wrapper incluido)

# Desde IDE

Ejecutar:

PolizasApiApplication.java

# Desde consola

Linux / Mac: ./mvnw spring-boot:run

Windows: mvnw.cmd spring-boot:run

# 6 . Endpoints Disponibles

GET /api/v1/polizas?tipo=COLECTIVA&estado=ACTIVA

POST /api/v1/polizas/{id}/renovar

POST /api/v1/polizas/{id}/cancelar

POST /api/v1/polizas/{id}/riesgos

POST /api/v1/riesgos/{id}/cancelar

POST /core-mock/evento
