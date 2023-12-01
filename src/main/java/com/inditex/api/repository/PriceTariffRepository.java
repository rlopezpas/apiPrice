/**
 * Repositorio de datos para Precios
 */
package com.inditex.api.repository;

import com.inditex.api.repository.entity.PriceTariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PriceTariffRepository extends CrudRepository<PriceTariff, Integer> {
    /**
     * Obtiene el precio en un rango de fechas segun su id de producto y brand y lo
     * ordena por prioridad.
     * @param brandId identificador del brand
     * @param productId identificador del producto
     * @param applicationDate fecha para aplicar al inicio
     * @param applicationDate2 fecha para aplicar al final.
     * @return
     */
    List<PriceTariff> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            int brandId, int productId, ZonedDateTime  applicationDate, ZonedDateTime applicationDate2);

}
