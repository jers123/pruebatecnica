package org.javatest.assetdepreciation.model;

import lombok.Getter;

@Getter
public enum Depreciation {
    CONSTRUCCIONES_EDIFICIOS("Construcciones y edificaciones", 45, 2.22),
    ACUEDUCTO_PLANTA("Acueducto, planta y redes", 40, 2.5),
    VIAS_COMUNICACION("Vías de comunicación", 40, 2.5),
    FLOTA_AEREA("Flota y equipo aéreo", 30, 3.33),
    FLOTA_FERREA("Flota y equipo férreo", 20, 5),
    FLOTA_FLUVIAL("Flota y equipo fluvial", 15, 6.67),
    ARMAMENTO_VIGILANCIA("Armamento y equipo de vigilancia", 10, 10),
    EQUIPO_ELECTRICO("Equipo eléctrico", 10, 10),
    FLOTA_TERRESTRE("Flota y equipo de transporte terrestre", 10, 10),
    MAQUINARIA_EQUIPOS("Maquinaria, equipos", 10, 10),
    MUEBLES_ENSERES("Muebles y enseres", 10, 10),
    EQUIPO_MEDICO("Equipo médico científico", 8, 12.5),
    ENVASES_HERRAMIENTAS("Envases, empaques y herramientas", 5, 20),
    COMPUTADORES_OFICINA("Computadores y equipos de oficina", 5, 20),
    REDES_DATOS("Redes de procesamiento de datos", 5, 20);

    private final String activeType;
    private final Integer usefulLife;
    private final Double annualPercentage;

    Depreciation(String activeType, Integer usefulLife, double annualPercentage) {
        this.activeType = activeType;
        this.usefulLife = usefulLife;
        this.annualPercentage = annualPercentage;
    }
}