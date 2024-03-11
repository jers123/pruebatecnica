package org.javatest.assetdepreciation.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DepresiationType {
    private String tipoActivo;
    private Integer vidaUtil;
    private Double porsentajeAnual;
}