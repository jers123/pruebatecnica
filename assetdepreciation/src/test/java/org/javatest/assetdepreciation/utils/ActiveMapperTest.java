package org.javatest.assetdepreciation.utils;

import org.javatest.assetdepreciation.model.Depreciation;
import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.model.dto.ActiveResult;
import org.javatest.assetdepreciation.model.dto.ActiveResults;
import org.javatest.assetdepreciation.model.dto.DepreciationType;
import org.javatest.assetdepreciation.model.entity.Active;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(OrderAnnotation.class)
class ActiveMapperTest {

    private ActiveMapper mapper;
    private ActiveDTO activeDto;
    private Active active;

    @BeforeEach
    void setUp() {
        mapper = new ActiveMapper();
        activeDto = new ActiveDTO();
        activeDto.setIdActivo(1);
        activeDto.setSerial("12abc3");
        activeDto.setNombre("pc de mesa");
        activeDto.setDescripcion("pc todo en uno");
        activeDto.setFechaCompra(LocalDate.now());
        activeDto.setValorCompra(2000000.0);
        activeDto.setDepreciacion(Depreciation.COMPUTADORES_OFICINA);

        active = new Active();
        active.setIdActive(1);
        active.setSerial("123abc");
        active.setName("Mesa");
        active.setDescription("escritorio de pc");
        active.setPurchaseDate(LocalDate.now());
        active.setPurchaseValue(400000.0);
        active.setDepreciationType(Depreciation.MUEBLES_ENSERES);
    }

    @Test
    @Order(1)
    void testCreate() {
        active = mapper.create(activeDto);

        assertNotNull(active);
        assertNull(active.getIdActive());
        assertNotNull(active.getSerial());
        assertNotNull(active.getName());
        assertNotNull(active.getDescription());
        assertNotNull(active.getPurchaseDate());
        assertNotNull(active.getPurchaseValue());
        assertNotNull(active.getDepreciationType());

        assertNotEquals(activeDto.getIdActivo(), active.getIdActive());
        assertEquals(activeDto.getSerial(), active.getSerial());
        assertEquals(activeDto.getNombre(), active.getName());
        assertEquals(activeDto.getDescripcion(), active.getDescription());
        assertEquals(activeDto.getFechaCompra(), active.getPurchaseDate());
        assertEquals(activeDto.getValorCompra(), active.getPurchaseValue());
        assertEquals(activeDto.getDepreciacion(), active.getDepreciationType());
    }

    @Test
    @Order(2)
    void testRead() {
        ActiveResult activeResult = mapper.read(active);

        assertNotNull(activeResult);
        assertNotNull(activeResult.getIdActivo());
        assertNotNull(activeResult.getSerial());
        assertNotNull(activeResult.getNombre());
        assertNotNull(activeResult.getDescripcion());
        assertNotNull(activeResult.getFechaCompra());
        assertNotNull(activeResult.getValorCompra());
        assertNotNull(activeResult.getDepreciacion());
        assertNotNull(activeResult.getTipoDepreciacion());
        assertNotNull(activeResult.getTipoDepreciacion().getTipoActivo());
        assertNotNull(activeResult.getTipoDepreciacion().getVidaUtil());
        assertNotNull(activeResult.getTipoDepreciacion().getPorcentajeAnual());

        assertEquals(active.getIdActive(), activeResult.getIdActivo());
        assertEquals(active.getSerial(), activeResult.getSerial());
        assertEquals(active.getName(), activeResult.getNombre());
        assertEquals(active.getDescription(), activeResult.getDescripcion());
        assertEquals(active.getPurchaseDate(), activeResult.getFechaCompra());
        assertEquals(active.getPurchaseValue(), activeResult.getValorCompra());
        assertEquals(active.getDepreciationType(), activeResult.getDepreciacion());
        assertEquals(active.getDepreciationType().getActiveType(), activeResult.getTipoDepreciacion().getTipoActivo());
        assertEquals(active.getDepreciationType().getUsefulLife(), activeResult.getTipoDepreciacion().getVidaUtil());
        assertEquals(active.getDepreciationType().getAnnualPercentage(), activeResult.getTipoDepreciacion().getPorcentajeAnual());
    }

    @Test
    @Order(3)
    public void testReadAll() {
        ActiveResults activeResults = mapper.readAll(active);

        assertNotNull(activeResults);
        assertNotNull(activeResults.getIdActivo());
        assertNotNull(activeResults.getSerial());
        assertNotNull(activeResults.getNombre());
        assertNotNull(activeResults.getDescripcion());
        assertNotNull(activeResults.getFechaCompra());
        assertNotNull(activeResults.getValorCompra());
        assertNotNull(activeResults.getDepreciacion());
        assertNotNull(activeResults.getTipoDepreciacion());
        assertNotNull(activeResults.getTipoDepreciacion().getTipoActivo());
        assertNotNull(activeResults.getTipoDepreciacion().getVidaUtil());
        assertNotNull(activeResults.getTipoDepreciacion().getPorcentajeAnual());

        assertEquals(active.getIdActive(), activeResults.getIdActivo());
        assertEquals(active.getSerial(), activeResults.getSerial());
        assertEquals(active.getName(), activeResults.getNombre());
        assertEquals(active.getDescription(), activeResults.getDescripcion());
        assertEquals(active.getPurchaseDate(), activeResults.getFechaCompra());
        assertEquals(active.getPurchaseValue(), activeResults.getValorCompra());
        assertEquals(active.getDepreciationType(), activeResults.getDepreciacion());
        assertEquals(active.getDepreciationType().getActiveType(), activeResults.getTipoDepreciacion().getTipoActivo());
        assertEquals(active.getDepreciationType().getUsefulLife(), activeResults.getTipoDepreciacion().getVidaUtil());
        assertEquals(active.getDepreciationType().getAnnualPercentage(), activeResults.getTipoDepreciacion().getPorcentajeAnual());
    }

    @Test
    @Order(4)
    public void testUpdate() {
        active = null;
        active = mapper.update(activeDto, active);

        assertNotNull(active);
        assertNotNull(active.getIdActive());
        assertNotNull(active.getSerial());
        assertNotNull(active.getName());
        assertNotNull(active.getDescription());
        assertNotNull(active.getPurchaseDate());
        assertNotNull(active.getPurchaseValue());
        assertNotNull(active.getDepreciationType());

        assertEquals(activeDto.getIdActivo(), active.getIdActive());
        assertEquals(activeDto.getSerial(), active.getSerial());
        assertEquals(activeDto.getNombre(), active.getName());
        assertEquals(activeDto.getDescripcion(), active.getDescription());
        assertEquals(activeDto.getFechaCompra(), active.getPurchaseDate());
        assertEquals(activeDto.getValorCompra(), active.getPurchaseValue());
        assertEquals(activeDto.getDepreciacion(), active.getDepreciationType());
    }

    @Test
    void testreadDepresiationType() {
        Depreciation depreciation = Depreciation.COMPUTADORES_OFICINA;
        DepreciationType depreciationType = mapper.readDepreciationType(depreciation);

        assertNotNull(depreciationType);
        assertNotNull(depreciationType.getTipoActivo());
        assertNotNull(depreciationType.getVidaUtil());
        assertNotNull(depreciationType.getPorcentajeAnual());

        assertEquals(depreciation.getActiveType(), depreciationType.getTipoActivo());
        assertEquals(depreciation.getUsefulLife(), depreciationType.getVidaUtil());
        assertEquals(depreciation.getAnnualPercentage(), depreciationType.getPorcentajeAnual());
    }

    @AfterEach
    void tearDown() {
        activeDto = null;
        active = null;
        mapper = null;
    }
}