/**
 * Objeto personalizado de error
 */
package com.inditex.api.controller.exception;

import com.inditex.api.controller.dto.ErrorResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorResponseDTO errorResponse;

    CustomException(ErrorResponseDTO errorResponse) {
        this.errorResponse = errorResponse;
    }

    /**
     * Crea un objeto personalizado de error con el codigo http, el codigo interno y el mensaje
     * @param httpStatus codigo http
     * @param internalCode codigo de error interno
     * @param message mensaje de error
     * @return error personalizado
     */
    public static CustomException createException(HttpStatus httpStatus, String internalCode, String message) {
        return new CustomException(new ErrorResponseDTO(
                httpStatus.value(),
                internalCode,
                message
        ));
    }
}
