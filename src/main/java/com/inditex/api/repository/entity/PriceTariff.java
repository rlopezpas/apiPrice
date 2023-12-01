/**
 * Entidad de tarifa de precio por producto
 */
package com.inditex.api.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
//Se genera para evitar problemas potenciales con ciclos infinitos en relaciones bidireccionales
@EqualsAndHashCode(of = "priceId")
@ToString
public class PriceTariff {

    /**  identificador de la tabla price */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;
    /** Foreing key de foreing key de brand */
    private Integer brandId;
    /** fecha inicio  de precio de producto */
    private ZonedDateTime startDate;
    /** fecha fin de precio de producto */
    private ZonedDateTime endDate;
    /** id de tarifa aplicable */
    private Integer priceList;
    /** foreing key de producto */
    private Integer productId;
    /** prioridad de precio */
    private Integer priority;
    /** precio del producto */
    private BigDecimal finalPrice;
    /** tipo de moneda */
    private String currencyIso;
}
