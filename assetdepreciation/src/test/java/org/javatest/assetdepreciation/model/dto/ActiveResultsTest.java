package org.javatest.assetdepreciation.model.dto;

import org.javatest.assetdepreciation.model.Depreciation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ActiveResultsTest extends ActiveDTOTest {
    @Test
    void testSettersAndGettersActiveResults() {
        ActiveResults activeResults = new ActiveResults();
        Integer idActivo = 1;
        String serial = "12abc3";
        String nombre = "pc de mesa";
        String descripcion = "pc todo en uno";
        LocalDate fechaCompra = LocalDate.now();
        Double valorCompra = 2000000.0;
        Depreciation depreciacion = Depreciation.COMPUTADORES_OFICINA;

        activeResults.setIdActivo(idActivo);
        activeResults.setSerial(serial);
        activeResults.setNombre(nombre);
        activeResults.setDescripcion(descripcion);
        activeResults.setFechaCompra(fechaCompra);
        activeResults.setValorCompra(valorCompra);
        activeResults.setDepreciacion(depreciacion);
        DepresiationType depreciationType = new DepresiationType();
        depreciationType.setTipoActivo("Computadores y equipos de oficina");
        depreciationType.setVidaUtil(5);
        depreciationType.setPorcentajeAnual(20.0);
        activeResults.setTipoDepreciacion(depreciationType);

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

        assertEquals(idActivo, activeResults.getIdActivo());
        assertEquals(serial, activeResults.getSerial());
        assertEquals(nombre, activeResults.getNombre());
        assertEquals(descripcion, activeResults.getDescripcion());
        assertEquals(fechaCompra, activeResults.getFechaCompra());
        assertEquals(valorCompra, activeResults.getValorCompra());
        assertEquals(depreciacion, activeResults.getDepreciacion());
        assertEquals(depreciationType.getTipoActivo(), activeResults.getTipoDepreciacion().getTipoActivo());
        assertEquals(depreciationType.getVidaUtil(), activeResults.getTipoDepreciacion().getVidaUtil());
        assertEquals(depreciationType.getPorcentajeAnual(), activeResults.getTipoDepreciacion().getPorcentajeAnual());
    }
}