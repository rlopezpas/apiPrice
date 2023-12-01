/**
 * Clase que recoje y lanza de manera centralizada todas las excepciones de la aplicacion
 */
package com.inditex.api.controller.exception;

import com.inditex.api.controller.dto.ErrorResponseDTO;

public class CustomExceptionUtil {

    /**
     * Constructor privado
     */
    private CustomExceptionUtil() {
        // Constructor privado para evitar instancias de esta clase
    }

    /**
     * Genera una excepcion para un precion no encontrado
     * @return
     */
    public static CustomException precioNoEncontradoException() {
        return new CustomException(new ErrorResponseDTO(ErrorCode.PRECIO_NO_ENCONTRADO));
    }
}
