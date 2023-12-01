# ApiPrice - Proyecto Spring Boot con Maven

## Descripción del Proyecto

ApiPrice es un proyecto desarrollado en Spring Boot 3 con Maven, diseñado para gestionar y proporcionar información de precios. Este proyecto genera un archivo WAR que puede ser desplegado en un servidor Tomcat 10 y está desarrollado en Java 17.

## Requisitos Previos

Asegúrate de tener instalado lo siguiente antes de ejecutar el proyecto:

- Java 17
- Maven v3.9.5
- Tomcat 10

## Instrucciones de Despliegue

1. Navega al directorio del proyecto:

    ```bash
    cd ApiPrice
    ```

2. Compila el proyecto con Maven:

    ```bash
    mvn clean install
    ```

3. Copia el archivo WAR generado a la carpeta de despliegue de Tomcat (por defecto, la carpeta `webapps`):

    ```bash
    cp target/ApiPrice.war $CATALINA_HOME/webapps/
    ```

4. Inicia Tomcat:

    ```bash
    $CATALINA_HOME/bin/startup.sh
    ```

5. Accede a la aplicación a traves de Swagger en tu navegador:

    ```
    http://localhost:8080/api-price-1.0.0/swagger-ui/index.html
    ```

## Configuración

Puedes ajustar la configuración del proyecto editando el archivo `application.properties` ubicado en la carpeta `src/main/resources`.
