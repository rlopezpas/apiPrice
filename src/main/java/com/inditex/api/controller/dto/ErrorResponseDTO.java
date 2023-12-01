/**
 * Clase genérica para la respuesta de errores.
 */
package com.inditex.api.controller.dto;

import com.inditex.api.controller.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Tag(description = "Objeto generico de respuesta de error",name = "ErrorResponseDTO")
public class ErrorResponseDTO {

    /**
     * Contructor de enumerado
     * @param errorCode enumerado con datos a instanciar
     */
    public ErrorResponseDTO (ErrorCode errorCode){
        this.code= errorCode.getHttpCode();
        this.internalCode= errorCode.getCode();
        this.msgException=errorCode.getMessage();
    }
    /**
     * Codigo de error http
     */
    @Schema(description = "codigo http de error", example = "404")
    private int code;
    /**
     * Codigo de error interno
     */
    @Schema(description = "codigo interno", example = "01-0001")
    private String internalCode;
    /**
     * Mensaje de excepcion
     */
    @Schema(description = "mensaje de la excepcion", example = "Hubo un error en la peticion")
    private String msgException;
}
