package org.javatest.assetdepreciation.utils;

import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.model.dto.ActiveResult;
import org.javatest.assetdepreciation.model.dto.ActiveResults;
import org.javatest.assetdepreciation.model.dto.DepreciationType;
import org.javatest.assetdepreciation.model.entity.Active;
import org.javatest.assetdepreciation.model.Depreciation;
import org.springframework.stereotype.Component;

@Component
public class ActiveMapper {

    public Active create(ActiveDTO entityDto) {
        Active entity = new Active();
        entity.setSerial(entityDto.getSerial());
        entity.setName(entityDto.getNombre());
        entity.setDescription(entityDto.getDescripcion());
        entity.setPurchaseDate(entityDto.getFechaCompra());
        entity.setPurchaseValue(entityDto.getValorCompra());
        entity.setDepreciationType(entityDto.getDepreciacion());
        return entity;
    }

    public ActiveResult read(Active entity) {
        ActiveResult entityDto = new ActiveResult();
        entityDto.setIdActivo(entity.getIdActive());
        entityDto.setSerial(entity.getSerial());
        entityDto.setNombre(entity.getName());
        entityDto.setDescripcion(entity.getDescription());
        entityDto.setFechaCompra(entity.getPurchaseDate());
        entityDto.setValorCompra(entity.getPurchaseValue());
        entityDto.setDepreciacion(entity.getDepreciationType());
        entityDto.setTipoDepreciacion(readDepreciationType(entity.getDepreciationType()));
        return entityDto;
    }

    public ActiveResults readAll(Active entity) {
        ActiveResults entityDto = new ActiveResults();
        entityDto.setIdActivo(entity.getIdActive());
        entityDto.setSerial(entity.getSerial());
        entityDto.setNombre(entity.getName());
        entityDto.setDescripcion(entity.getDescription());
        entityDto.setFechaCompra(entity.getPurchaseDate());
        entityDto.setValorCompra(entity.getPurchaseValue());
        entityDto.setDepreciacion(entity.getDepreciationType());
        entityDto.setTipoDepreciacion(readDepreciationType(entity.getDepreciationType()));
        return entityDto;
    }

    public Active update(ActiveDTO entityDto, Active entity) {
        entity.setSerial(entityDto.getSerial());
        entity.setName(entityDto.getNombre());
        entity.setDescription(entityDto.getDescripcion());
        entity.setPurchaseDate(entityDto.getFechaCompra());
        entity.setPurchaseValue(entityDto.getValorCompra());
        entityDto.setDepreciacion(entity.getDepreciationType());
        return entity;
    }

    protected DepreciationType readDepreciationType(Depreciation depreciation) {
        DepreciationType depreciationType = new DepreciationType();
        depreciationType.setTipoActivo(depreciation.getActiveType());
        depreciationType.setVidaUtil(depreciation.getUsefulLife());
        depreciationType.setPorcentajeAnual(depreciation.getAnnualPercentage());
        return depreciationType;
    }
}