/**
 * Clase para el mapeo de precios
 */
package com.inditex.api.service.mapper;

import com.inditex.api.controller.dto.PriceTariffResponseDTO;
import com.inditex.api.repository.entity.PriceTariff;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceTariffMapper {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Convierte una entidada de base de datos de precio
     * en una entidada de negocio tipo precio
     * @param priceTariff entidad precio de base de datos
     * @return entidad precio de negocio
     */
    public PriceTariffResponseDTO convertToDto(PriceTariff priceTariff) {
        return modelMapper.map(priceTariff, PriceTariffResponseDTO.class);
    }
}