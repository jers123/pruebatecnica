package org.javatest.assetdepreciation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DepreciationTest {
    @Test
    void testNotNull() {
        for (Depreciation depreciation : Depreciation.values()) {
            assertNotNull(depreciation);
        }
    }

    @Test
    void testActiveTypeIsEquals() {
        assertEquals("Construcciones y edificaciones", Depreciation.CONSTRUCCIONES_EDIFICIOS.getActiveType());
        assertEquals("Acueducto, planta y redes", Depreciation.ACUEDUCTO_PLANTA.getActiveType());
        assertEquals("Vías de comunicación", Depreciation.VIAS_COMUNICACION.getActiveType());
        assertEquals("Flota y equipo aéreo", Depreciation.FLOTA_AEREA.getActiveType());
        assertEquals("Flota y equipo férreo", Depreciation.FLOTA_FERREA.getActiveType());
        assertEquals("Flota y equipo fluvial", Depreciation.FLOTA_FLUVIAL.getActiveType());
        assertEquals("Armamento y equipo de vigilancia", Depreciation.ARMAMENTO_VIGILANCIA.getActiveType());
        assertEquals("Equipo eléctrico", Depreciation.EQUIPO_ELECTRICO.getActiveType());
        assertEquals("Flota y equipo de transporte terrestre", Depreciation.FLOTA_TERRESTRE.getActiveType());
        assertEquals("Maquinaria, equipos", Depreciation.MAQUINARIA_EQUIPOS.getActiveType());
        assertEquals("Muebles y enseres", Depreciation.MUEBLES_ENSERES.getActiveType());
        assertEquals("Equipo médico científico", Depreciation.EQUIPO_MEDICO.getActiveType());
        assertEquals("Envases, empaques y herramientas", Depreciation.ENVASES_HERRAMIENTAS.getActiveType());
        assertEquals("Computadores y equipos de oficina", Depreciation.COMPUTADORES_OFICINA.getActiveType());
        assertEquals("Redes de procesamiento de datos", Depreciation.REDES_DATOS.getActiveType());
    }

    @Test
    void testUsefulLifeIsEquals() {
        assertEquals(45, Depreciation.CONSTRUCCIONES_EDIFICIOS.getUsefulLife());
        assertEquals(40, Depreciation.ACUEDUCTO_PLANTA.getUsefulLife());
        assertEquals(40, Depreciation.VIAS_COMUNICACION.getUsefulLife());
        assertEquals(30, Depreciation.FLOTA_AEREA.getUsefulLife());
        assertEquals(20, Depreciation.FLOTA_FERREA.getUsefulLife());
        assertEquals(15, Depreciation.FLOTA_FLUVIAL.getUsefulLife());
        assertEquals(10, Depreciation.ARMAMENTO_VIGILANCIA.getUsefulLife());
        assertEquals(10, Depreciation.EQUIPO_ELECTRICO.getUsefulLife());
        assertEquals(10, Depreciation.FLOTA_TERRESTRE.getUsefulLife());
        assertEquals(10, Depreciation.MAQUINARIA_EQUIPOS.getUsefulLife());
        assertEquals(10, Depreciation.MUEBLES_ENSERES.getUsefulLife());
        assertEquals(8, Depreciation.EQUIPO_MEDICO.getUsefulLife());
        assertEquals(5, Depreciation.ENVASES_HERRAMIENTAS.getUsefulLife());
        assertEquals(5, Depreciation.COMPUTADORES_OFICINA.getUsefulLife());
        assertEquals(5, Depreciation.REDES_DATOS.getUsefulLife());
    }

    @Test
    void testAnnualPercentageIsEquals() {
        assertEquals(2.22, Depreciation.CONSTRUCCIONES_EDIFICIOS.getAnnualPercentage());
        assertEquals(2.5, Depreciation.ACUEDUCTO_PLANTA.getAnnualPercentage());
        assertEquals(2.5, Depreciation.VIAS_COMUNICACION.getAnnualPercentage());
        assertEquals(3.33, Depreciation.FLOTA_AEREA.getAnnualPercentage());
        assertEquals(5.0, Depreciation.FLOTA_FERREA.getAnnualPercentage());
        assertEquals(6.67, Depreciation.FLOTA_FLUVIAL.getAnnualPercentage());
        assertEquals(10.0, Depreciation.ARMAMENTO_VIGILANCIA.getAnnualPercentage());
        assertEquals(10.0, Depreciation.EQUIPO_ELECTRICO.getAnnualPercentage());
        assertEquals(10.0, Depreciation.FLOTA_TERRESTRE.getAnnualPercentage());
        assertEquals(10.0, Depreciation.MAQUINARIA_EQUIPOS.getAnnualPercentage());
        assertEquals(10.0, Depreciation.MUEBLES_ENSERES.getAnnualPercentage());
        assertEquals(12.5, Depreciation.EQUIPO_MEDICO.getAnnualPercentage());
        assertEquals(20.0, Depreciation.ENVASES_HERRAMIENTAS.getAnnualPercentage());
        assertEquals(20.0, Depreciation.COMPUTADORES_OFICINA.getAnnualPercentage());
        assertEquals(20.0, Depreciation.REDES_DATOS.getAnnualPercentage());
    }
}