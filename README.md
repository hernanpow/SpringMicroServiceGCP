# Microservicios Spring Boot - Challenge

Este repositorio contiene una aplicación desarrollada en Spring Boot como parte de un challenge. La aplicación está estructurada en microservicios y cuenta con la documentación de las APIs disponible en Swagger.

## Características

- **Arquitectura de microservicios:** La aplicación está dividida en varios microservicios para una mejor modularidad y escalabilidad.
- **Spring Boot:** Utiliza Spring Boot para simplificar la configuración y el desarrollo de los microservicios.
- **Swagger UI:** Documentación interactiva de las APIs disponible en `localhost:8080/swagger-ui`.
- **BDD** Alojada en GCP.
- **Deploy** Para el deploy, tuve problemas que no pude deployarlo en AWS ni en GCP. Primer intento fue con GCP (Lo cual logre usar una BDD del mismo servicio que actualmente usa). Pero por alguna razon que desconozco,mi deploy nunca pudo ser exitoso. Lo mismo me paso para AWS. No se si fue algo con las versiones de mi proyecto y algunos archivos que dificultaban el deploy. Espero un feedback al respecto.

## Requisitos

- Java 11 o superior
- Maven 3.6.3 o superior

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/microservicios-springboot-challenge.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd microservicios-springboot-challenge
    ```
3. Compila y construye el proyecto utilizando Maven:
    ```bash
    mvn clean install
    ```

## Ejecución

Para ejecutar la aplicación, usa el siguiente comando de Maven:

```bash
mvn spring-boot:run


