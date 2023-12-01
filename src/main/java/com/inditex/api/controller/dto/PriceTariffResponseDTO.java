/**
 * Clase de respuesta de price tariff
*/
package com.inditex.api.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(of = "productId")
@ToString
@Tag(description = "Objeto de respuesta para un precio",name = "PriceTariffResponseDTO")
public class PriceTariffResponseDTO{
    /**
     * id de precio
     */
    @Schema(description = "id de precio", example = "1")
    private int priceId;

    /**
     * id de productos
     */
    @Schema(description = "id de producto", example = "35465")
    private int productId;
    /**
     * id de brand
     */
    @Schema(description = "id de brand", example = "1")
    private int brandId;
    /**
     * id lista de precio
     */
    @Schema(description = "id lista de precio", example = "1")
    private int priceList;
    /**
     * fecha inicial de rango de validez del precio
     */
    @Schema(description = "fecha inicial de rango de validez del precio", example = "2023-11-30T12:00:00")
    private ZonedDateTime startDate;
    /**
     * fecha final de rango de validez del precio
     */
    @Schema(description = "fecha final de rango de validez del precio", example = "2023-12-30T12:00:00")
    private ZonedDateTime endDate;
    /**
     * precio final
     */
    @Schema(description = "precio final", example = "35.96")
    private BigDecimal finalPrice;
    /**
     * tipo de moneda
     */
    @Schema(description = "tipo de moneda", example = "EUR")
    private String currencyIso;

}
