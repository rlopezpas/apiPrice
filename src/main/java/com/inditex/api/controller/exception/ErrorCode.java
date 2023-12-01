/**
 * Clase para la declaracion de todos los tipos de errores de nuestra aplicacion.
 */
package com.inditex.api.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //Errores a nivel general del aplicativo
    ERROR_INTERNO_GENERICO("01-0001", HttpStatus.INTERNAL_SERVER_ERROR.value(),"Ocurrio un error interno"),
    PARAMETROS_INCORRECTOS_GENERICO("01-0002",HttpStatus.BAD_REQUEST.value(), "Parametros incorrectos"),
    //Errores para precio
    PRECIO_NO_ENCONTRADO("02-0001",HttpStatus.NOT_FOUND.value(), "precio no encontrado"),
    PARAMETROS_PRECIO_INCORRECTOS("02-0002",HttpStatus.BAD_REQUEST.value(), "Los parámetros de entrada" +
            " no son correctos. Revise el formato de los parametros o asegurese de que envia los parametros correctos.");
    // Agrega más códigos según tus necesidades

    private final String code;
    private final int httpCode;
    private final String message;
}