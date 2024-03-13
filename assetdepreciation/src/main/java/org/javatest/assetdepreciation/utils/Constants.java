package org.javatest.assetdepreciation.utils;

import static org.javatest.assetdepreciation.utils.SystemConstants.DESCRIPTION_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.NAME_LENGTH;
import static org.javatest.assetdepreciation.utils.SystemConstants.SERIAL_LENGTH;

public final class Constants {
    public static final String NO_CONTENT = "No hay registros";
    public static final String NO_CONTENT_ID = "No hay registros con el id = ";
    public static final String YES_CONTENT = "Si hay registros";

    // ERRORS
    public static final String HTTP_MESSAGE1 = "Problema de método HTTP, se esperaba la petición por medio del método ";
    public static final String HTTP_MESSAGE2 = " pero se solicitó por medio del metodo ";

    //ACTIVE
    public static final String ACTIVE_DESCRIPTION_SIZE = "El tamaño de la descripción del activo es máximo de " + DESCRIPTION_LENGTH + ".";
    public static final String ACTIVE_NAME_NOT_NULL = "El nombre del activo no puede ser nulo.";
    public static final String ACTIVE_NAME_SIZE = "El tamaño del nombre del activo es mínimo de 1 y máximo de " + NAME_LENGTH + ".";
    public static final String ACTIVE_PURCHASE_DATE_NOT_NULL = "La fecha de compra del activo no puede ser nulo.";
    public static final String ACTIVE_PURCHASE_VALUE_NOT_NULL = "El valor de compra del activo no puede ser nulo.";
    public static final String ACTIVE_SERIAL_EXISTS = "El serial del activo ya existe.";
    public static final String ACTIVE_SERIAL_NOT_NULL = "El serial del activo no puede ser nulo.";
    public static final String ACTIVE_SERIAL_SIZE = "El tamaño del serial del activo es mínimo de 1 y máximo de " + SERIAL_LENGTH + ".";
    public static final String ACTIVE_DEPRECIATION_TYPE_NOT_NULL = "El tpo de depresiación del activo no puede ser nulo.";

    public static final String SUCCESSFULLY_CREATED_ACTIVE = "Activo creado exitosamente.";
    public static final String SUCCESSFULLY_DELETED_ACTIVE = "Activo eliminado exitosamente.";
    public static final String SUCCESSFULLY_UPDATED_ACTIVE = "Activo actualizado exitosamente.";
}