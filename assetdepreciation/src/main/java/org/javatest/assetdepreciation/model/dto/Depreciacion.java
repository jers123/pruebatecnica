package org.javatest.assetdepreciation.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Depreciacion {
    private Integer anioNumero;
    private LocalDate fecha;
    private Double valorDepreciacion;
}