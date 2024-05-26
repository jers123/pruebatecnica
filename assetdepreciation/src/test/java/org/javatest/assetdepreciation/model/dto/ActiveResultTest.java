package org.javatest.assetdepreciation.model.dto;

import org.javatest.assetdepreciation.model.Depreciation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ActiveResultTest extends ActiveResultsTest {
    @Test
    void testSettersAndGettersActiveResult() {
        ActiveResult activeResult = new ActiveResult();
        Integer idActivo = 1;
        String serial = "12abc3";
        String nombre = "pc de mesa";
        String descripcion = "pc todo en uno";
        LocalDate fechaCompra = LocalDate.now();
        Double valorCompra = 2000000.0;
        Depreciation depreciacion = Depreciation.COMPUTADORES_OFICINA;
        DepreciationType depreciationType = new DepreciationType();
        depreciationType.setTipoActivo("Computadores y equipos de oficina");
        depreciationType.setVidaUtil(5);
        depreciationType.setPorcentajeAnual(20.0);
        List<Depreciacion> depreciaciones = new ArrayList<>();
        Depreciacion depreciacions = new Depreciacion();
        depreciacions.setAnioNumero(1);
        depreciacions.setFecha(fechaCompra.plusYears(1));
        depreciacions.setValorDepreciacion(1600000.0);
        depreciaciones.add(depreciacions);

        activeResult.setIdActivo(idActivo);
        activeResult.setSerial(serial);
        activeResult.setNombre(nombre);
        activeResult.setDescripcion(descripcion);
        activeResult.setFechaCompra(fechaCompra);
        activeResult.setValorCompra(valorCompra);
        activeResult.setDepreciacion(depreciacion);
        activeResult.setTipoDepreciacion(depreciationType);
        activeResult.setDepreciaciones(depreciaciones);

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
        assertNotNull(activeResult.getDepreciaciones());
        assertNotNull(activeResult.getDepreciaciones().get(0).getAnioNumero());
        assertNotNull(activeResult.getDepreciaciones().get(0).getFecha());
        assertNotNull(activeResult.getDepreciaciones().get(0).getValorDepreciacion());

        assertEquals(idActivo, activeResult.getIdActivo());
        assertEquals(serial, activeResult.getSerial());
        assertEquals(nombre, activeResult.getNombre());
        assertEquals(descripcion, activeResult.getDescripcion());
        assertEquals(fechaCompra, activeResult.getFechaCompra());
        assertEquals(valorCompra, activeResult.getValorCompra());
        assertEquals(depreciacion, activeResult.getDepreciacion());
        assertEquals(depreciationType.getTipoActivo(), activeResult.getTipoDepreciacion().getTipoActivo());
        assertEquals(depreciationType.getVidaUtil(), activeResult.getTipoDepreciacion().getVidaUtil());
        assertEquals(depreciationType.getPorcentajeAnual(), activeResult.getTipoDepreciacion().getPorcentajeAnual());
        assertEquals(depreciacions.getAnioNumero(), activeResult.getDepreciaciones().get(0).getAnioNumero());
        assertEquals(depreciacions.getFecha(), activeResult.getDepreciaciones().get(0).getFecha());
        assertEquals(depreciacions.getValorDepreciacion(), activeResult.getDepreciaciones().get(0).getValorDepreciacion());
    }
}