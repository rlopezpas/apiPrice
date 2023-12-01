/**
 * Controlador de la api de price controller
 */
package com.inditex.api.controller;

import com.inditex.api.controller.dto.ErrorResponseDTO;
import com.inditex.api.controller.dto.PriceTariffResponseDTO;
import com.inditex.api.service.PriceTariffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/price-tariff")
public class PriceController {

    @Autowired
    PriceTariffService priceTariffService;

    /**
     * Realiza una consulta sobre los precios ateniendose a su fecha, producto y brand
     * @param applicationDate fecha del precio
     * @param productId identificador de producto
     * @param brandId identificador del brand
     * @return resultado del precio buscado.
     */
    @Operation(summary = "Busca el precio de un producto segun la fecha y su brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro el precio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceTariffResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros no validos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Precio no encontrado",
                    content ={ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class)) }),
    @ApiResponse(responseCode = "500", description = "Error interno",
            content ={ @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDTO.class)) }) })
    @GetMapping("/price")
    public PriceTariffResponseDTO findPrice(
            @Parameter(description = "fecha de aplicacion del precio en formato ISO-8631", example = "2020-06-14T09:00:00+00:02")
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime applicationDate,
            @Parameter(description = "id del producto", example = "35455")
            @RequestParam("productId") int productId,
            @Parameter(description = "id del brand",example = "1")
            @RequestParam("brandId") int brandId
    ) {
        return priceTariffService.consultPriceTariff(applicationDate,productId,brandId);
    }
}
