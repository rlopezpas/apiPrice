/**
 * Manejador de errores general
 */
package com.inditex.api.controller.exception;

import com.inditex.api.controller.dto.ErrorResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * Manejador de excepciones personalizadas
     * @param ex excepcion personalizada
     * @return error personalizado
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        ErrorResponseDTO errorResponse = ex.getErrorResponse();
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getCode()));
    }

    /**
     * Capturador generico de excepciones internas
     * @param ex excepcion generica
     * @return error formateado
     */
   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public ResponseEntity<Object> handleInternalServerError(Exception ex) {
       //Caso de badRequest generales antes de la capa de servicio
       if(ex instanceof ErrorResponse||
               ex instanceof MethodArgumentTypeMismatchException){
           log.debug("ocurrio un error de envio/respuesta con la api: ",ex);
           ErrorResponseDTO errorResponse = new ErrorResponseDTO(ErrorCode.PARAMETROS_INCORRECTOS_GENERICO);
           //En este caso se sobreescribe el mensaje por si quisieramos usar la validación de Spring a nivel de DTO
           errorResponse.setMsgException(ex.getMessage());
           return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getCode()));
       }else{
           //Error general no capturado
           log.error("Ocurrio un error inesperado:",ex);
           ErrorResponseDTO errorResponse = new ErrorResponseDTO(ErrorCode.ERROR_INTERNO_GENERICO);
           return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getCode()));
       }
    }
}
