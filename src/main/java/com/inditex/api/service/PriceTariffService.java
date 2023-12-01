/**
 * Servicio de tarifa de precios
 */
package com.inditex.api.service;

import com.inditex.api.controller.dto.PriceTariffResponseDTO;
import com.inditex.api.repository.PriceTariffRepository;
import com.inditex.api.repository.entity.PriceTariff;
import com.inditex.api.service.mapper.PriceTariffMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

import static com.inditex.api.controller.exception.CustomExceptionUtil.precioNoEncontradoException;

@Service
@Log4j2
public class PriceTariffService {

    @Autowired
    private PriceTariffRepository priceTariffRepository;

    @Autowired
    private PriceTariffMapper priceTariffMapper;

    /**
     * Obtiene de la base de datos los precios entre una fecha inicial y final respecto
     * a su brand y producto. En caso no encontrarlo lanzara un error de no encontrado.
     * @param applicationDate fecha de la busqueda de precio
     * @param productId identificador del producto
     * @param brandId identificador del brand.
     * @return objeto de negocio tipo Precio encontrado.
     */
    public PriceTariffResponseDTO consultPriceTariff(ZonedDateTime applicationDate, int productId, int brandId) {
        List<PriceTariff> tariffs = priceTariffRepository
                .findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        brandId, productId, applicationDate, applicationDate);

        if (tariffs != null && !tariffs.isEmpty()) {
            PriceTariff selectedTariff = tariffs.get(0); // Tomar la tarifa de mayor prioridad
            log.info("precio encontrado con Id: "+selectedTariff.getPriceId());
            // Construir DTO para el resultado
            return priceTariffMapper.convertToDto(selectedTariff);
        } else {
            log.info("No se encontro ningun precio");
            throw precioNoEncontradoException();
        }
    }
}
