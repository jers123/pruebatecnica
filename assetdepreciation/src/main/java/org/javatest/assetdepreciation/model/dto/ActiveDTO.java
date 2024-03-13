package org.javatest.assetdepreciation.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javatest.assetdepreciation.model.Depreciation;

import java.time.LocalDate;

import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_DEPRECIATION_TYPE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_DESCRIPTION_SIZE;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_NAME_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_NAME_SIZE;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_PURCHASE_DATE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_PURCHASE_VALUE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_SERIAL_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_SERIAL_SIZE;
import static org.javatest.assetdepreciation.utils.SystemConstants.DESCRIPTION_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.NAME_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.SERIAL_LENGTH;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ActiveDTO {
    @Schema(defaultValue = "1")
    private Integer idActivo;

    @NotNull(message = ACTIVE_SERIAL_NOT_NULL)
    @Size(min = 1, max = SERIAL_LENGTH, message = ACTIVE_SERIAL_SIZE)
    @Schema(defaultValue = "123abc")
    private String serial;

    @NotNull(message = ACTIVE_NAME_NOT_NULL)
    @Size(min = 1, max = NAME_LENGTH, message = ACTIVE_NAME_SIZE)
    @Schema(defaultValue = "pc mesa")
    private String nombre;

    @Size(max = DESCRIPTION_LENGTH, message = ACTIVE_DESCRIPTION_SIZE)
    @Schema(defaultValue = "pc todo en uno")
    private String descripcion;

    @NotNull(message = ACTIVE_PURCHASE_DATE_NOT_NULL)
    @Schema(defaultValue = "2020-03-11")
    private LocalDate fechaCompra;

    @NotNull(message = ACTIVE_PURCHASE_VALUE_NOT_NULL)
    @Schema(defaultValue = "2000000")
    private Double valorCompra;

    @NotNull(message = ACTIVE_DEPRECIATION_TYPE_NOT_NULL)
    @Schema(defaultValue = "13")
    private Depreciation depreciacion;
}