package org.javatest.assetdepreciation.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DepresiationTypeTest {

    @Test
    void testSettersAndGetters() {
        DepreciationType depreciationType = new DepreciationType();

        String tipoActivo = "Computadores y equipos de oficina";
        Integer vidaUtil = 5;
        Double porcentajeAnual = 20.0;

        depreciationType.setTipoActivo(tipoActivo);
        depreciationType.setVidaUtil(vidaUtil);
        depreciationType.setPorcentajeAnual(porcentajeAnual);

        assertNotNull(depreciationType.getTipoActivo());
        assertNotNull(depreciationType.getVidaUtil());
        assertNotNull(depreciationType.getPorcentajeAnual());

        assertEquals(tipoActivo, depreciationType.getTipoActivo());
        assertEquals(vidaUtil, depreciationType.getVidaUtil());
        assertEquals(porcentajeAnual, depreciationType.getPorcentajeAnual());
    }
}