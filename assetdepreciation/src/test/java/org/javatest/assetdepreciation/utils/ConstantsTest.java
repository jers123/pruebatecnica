package org.javatest.assetdepreciation.utils;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(OrderAnnotation.class)
class ConstantsTest {
    @Test
    @Order(1)
    void testNotNullConstants() {
        assertNotNull(Constants.NO_CONTENT);
        assertNotNull(Constants.NO_CONTENT_ID);
        assertNotNull(Constants.YES_CONTENT);
        assertNotNull(Constants.HTTP_MESSAGE1);
        assertNotNull(Constants.HTTP_MESSAGE2);
        assertNotNull(Constants.ACTIVE_DESCRIPTION_SIZE);
        assertNotNull(Constants.ACTIVE_NAME_NOT_NULL);
        assertNotNull(Constants.ACTIVE_NAME_SIZE);
        assertNotNull(Constants.ACTIVE_PURCHASE_DATE_NOT_NULL);
        assertNotNull(Constants.ACTIVE_PURCHASE_VALUE_NOT_NULL);
        assertNotNull(Constants.ACTIVE_SERIAL_EXISTS);
        assertNotNull(Constants.ACTIVE_SERIAL_NOT_NULL);
        assertNotNull(Constants.ACTIVE_SERIAL_SIZE);
        assertNotNull(Constants.ACTIVE_DEPRECIATION_TYPE_NOT_NULL);
        assertNotNull(Constants.SUCCESSFULLY_CREATED_ACTIVE);
        assertNotNull(Constants.SUCCESSFULLY_DELETED_ACTIVE);
        assertNotNull(Constants.SUCCESSFULLY_UPDATED_ACTIVE);
    }

    @Test
    @Order(2)
    void testNotEmptyConstants() {
        assertFalse(Constants.NO_CONTENT.isEmpty());
        assertFalse(Constants.NO_CONTENT_ID.isEmpty());
        assertFalse(Constants.YES_CONTENT.isEmpty());
        assertFalse(Constants.HTTP_MESSAGE1.isEmpty());
        assertFalse(Constants.HTTP_MESSAGE2.isEmpty());
        assertFalse(Constants.ACTIVE_DESCRIPTION_SIZE.isEmpty());
        assertFalse(Constants.ACTIVE_NAME_NOT_NULL.isEmpty());
        assertFalse(Constants.ACTIVE_NAME_SIZE.isEmpty());
        assertFalse(Constants.ACTIVE_PURCHASE_DATE_NOT_NULL.isEmpty());
        assertFalse(Constants.ACTIVE_PURCHASE_VALUE_NOT_NULL.isEmpty());
        assertFalse(Constants.ACTIVE_SERIAL_EXISTS.isEmpty());
        assertFalse(Constants.ACTIVE_SERIAL_NOT_NULL.isEmpty());
        assertFalse(Constants.ACTIVE_SERIAL_SIZE.isEmpty());
        assertFalse(Constants.ACTIVE_DEPRECIATION_TYPE_NOT_NULL.isEmpty());
        assertFalse(Constants.SUCCESSFULLY_CREATED_ACTIVE.isEmpty());
        assertFalse(Constants.SUCCESSFULLY_DELETED_ACTIVE.isEmpty());
        assertFalse(Constants.SUCCESSFULLY_UPDATED_ACTIVE.isEmpty());
    }

    @Test
    @Order(3)
    void testEquealsConstants() {
        assertEquals("No hay registros", Constants.NO_CONTENT);
        assertEquals("No hay registros con el id = ", Constants.NO_CONTENT_ID);
        assertEquals("Si hay registros", Constants.YES_CONTENT);
        assertEquals("Problema de método HTTP, se esperaba la petición por medio del método ", Constants.HTTP_MESSAGE1);
        assertEquals(" pero se solicitó por medio del metodo ", Constants.HTTP_MESSAGE2);
        assertEquals("El tamaño de la descripción del activo es máximo de 100.", Constants.ACTIVE_DESCRIPTION_SIZE);
        assertEquals("El nombre del activo no puede ser nulo.", Constants.ACTIVE_NAME_NOT_NULL);
        assertEquals("El tamaño del nombre del activo es mínimo de 1 y máximo de 50.", Constants.ACTIVE_NAME_SIZE);
        assertEquals("La fecha de compra del activo no puede ser nulo.", Constants.ACTIVE_PURCHASE_DATE_NOT_NULL);
        assertEquals("El valor de compra del activo no puede ser nulo.", Constants.ACTIVE_PURCHASE_VALUE_NOT_NULL);
        assertEquals("El serial del activo ya existe.", Constants.ACTIVE_SERIAL_EXISTS);
        assertEquals("El serial del activo no puede ser nulo.", Constants.ACTIVE_SERIAL_NOT_NULL);
        assertEquals("El tamaño del serial del activo es mínimo de 1 y máximo de 10.", Constants.ACTIVE_SERIAL_SIZE);
        assertEquals("El tpo de depresiación del activo no puede ser nulo.", Constants.ACTIVE_DEPRECIATION_TYPE_NOT_NULL);
        assertEquals("Activo creado exitosamente.", Constants.SUCCESSFULLY_CREATED_ACTIVE);
        assertEquals("Activo eliminado exitosamente.", Constants.SUCCESSFULLY_DELETED_ACTIVE);
        assertEquals("Activo actualizado exitosamente.", Constants.SUCCESSFULLY_UPDATED_ACTIVE);
    }
}