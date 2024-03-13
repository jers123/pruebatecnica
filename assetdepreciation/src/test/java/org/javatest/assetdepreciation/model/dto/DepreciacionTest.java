package org.javatest.assetdepreciation.model.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DepreciacionTest {
    @Test
    void testSettersAndGetters() {
        Depreciacion depreciacion = new Depreciacion();

        Integer anioNumero = 1;
        LocalDate fecha = LocalDate.now();
        Double valorDepreciacion = 1000.0;

        depreciacion.setAnioNumero(anioNumero);
        depreciacion.setFecha(fecha);
        depreciacion.setValorDepreciacion(valorDepreciacion);

        assertNotNull(depreciacion.getAnioNumero());
        assertNotNull(depreciacion.getFecha());
        assertNotNull(depreciacion.getValorDepreciacion());

        assertEquals(anioNumero, depreciacion.getAnioNumero());
        assertEquals(fecha, depreciacion.getFecha());
        assertEquals(valorDepreciacion, depreciacion.getValorDepreciacion());
    }
}