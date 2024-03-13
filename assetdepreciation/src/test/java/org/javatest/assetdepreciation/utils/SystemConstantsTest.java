package org.javatest.assetdepreciation.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.javatest.assetdepreciation.utils.SystemConstants.CONTENT_TYPE;
import static org.javatest.assetdepreciation.utils.SystemConstants.answer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SystemConstantsTest {

    @Test
    void testNotNullConstants() {
        assertNotNull(SystemConstants.LOCAL_ORIGIN_PATH);
        assertNotNull(SystemConstants.ASSET_DEPRECIATION_PATH);
        assertNotNull(SystemConstants.CREATE_PATH);
        assertNotNull(SystemConstants.DELETE_PATH);
        assertNotNull(SystemConstants.GET_ALL_PATH);
        assertNotNull(SystemConstants.GET_ID_PATH);
        assertNotNull(SystemConstants.UPDATE_PATH);
        assertNotNull(SystemConstants.CONTENT_TYPE);
        assertNotNull(SystemConstants.DATABASE);
        assertNotNull(SystemConstants.SCHEMA);
        assertNotNull(SystemConstants.ACTIVE_TABLE);
        assertNotNull(SystemConstants.DEPRECIATION_TYPE);
        assertNotNull(SystemConstants.DESCRIPTION);
        assertNotNull(SystemConstants.DESCRIPTION_LENGTH);
        assertNotNull(SystemConstants.ID);
        assertNotNull(SystemConstants.NAME);
        assertNotNull(SystemConstants.NAME_LENGTH);
        assertNotNull(SystemConstants.PURCHASE_DATE);
        assertNotNull(SystemConstants.PURCHASE_VALUE);
        assertNotNull(SystemConstants.SERIAL);
        assertNotNull(SystemConstants.SERIAL_LENGTH);
        assertNotNull(SystemConstants.ACTIVE_SERIAL_QUERY);
    }

    @Test
    void testNotEmptyConstants() {
        assertFalse(SystemConstants.LOCAL_ORIGIN_PATH.isEmpty());
        assertFalse(SystemConstants.ASSET_DEPRECIATION_PATH.isEmpty());
        assertFalse(SystemConstants.CREATE_PATH.isEmpty());
        assertFalse(SystemConstants.DELETE_PATH.isEmpty());
        assertFalse(SystemConstants.GET_ALL_PATH.isEmpty());
        assertFalse(SystemConstants.GET_ID_PATH.isEmpty());
        assertFalse(SystemConstants.UPDATE_PATH.isEmpty());
        assertFalse(SystemConstants.CONTENT_TYPE.isEmpty());
        assertFalse(SystemConstants.DATABASE.isEmpty());
        assertFalse(SystemConstants.SCHEMA.isEmpty());
        assertFalse(SystemConstants.ACTIVE_TABLE.isEmpty());
        assertFalse(SystemConstants.DEPRECIATION_TYPE.isEmpty());
        assertFalse(SystemConstants.DESCRIPTION.isEmpty());
        assertFalse(SystemConstants.ID.isEmpty());
        assertFalse(SystemConstants.NAME.isEmpty());
        assertFalse(SystemConstants.PURCHASE_DATE.isEmpty());
        assertFalse(SystemConstants.PURCHASE_VALUE.isEmpty());
        assertFalse(SystemConstants.SERIAL.isEmpty());
        assertFalse(SystemConstants.ACTIVE_SERIAL_QUERY.isEmpty());
    }

    @Test
    void testEquealsConstants() {
        assertEquals("http://localhost:8080", SystemConstants.LOCAL_ORIGIN_PATH);
        assertEquals("/assetdepreciation", SystemConstants.ASSET_DEPRECIATION_PATH);
        assertEquals("/create", SystemConstants.CREATE_PATH);
        assertEquals("/delete/", SystemConstants.DELETE_PATH);
        assertEquals("/get-all", SystemConstants.GET_ALL_PATH);
        assertEquals("/get-id/", SystemConstants.GET_ID_PATH);
        assertEquals("/update", SystemConstants.UPDATE_PATH);
        assertEquals("Content-Type", SystemConstants.CONTENT_TYPE);
        assertEquals("test", SystemConstants.DATABASE);
        assertEquals("public", SystemConstants.SCHEMA);
        assertEquals("activos", SystemConstants.ACTIVE_TABLE);
        assertEquals("tipo_depresiacion", SystemConstants.DEPRECIATION_TYPE);
        assertEquals("descripcion", SystemConstants.DESCRIPTION);
        assertEquals(100, SystemConstants.DESCRIPTION_LENGTH);
        assertEquals("id", SystemConstants.ID);
        assertEquals("nombre", SystemConstants.NAME);
        assertEquals(50, SystemConstants.NAME_LENGTH);
        assertEquals("fecha_compra", SystemConstants.PURCHASE_DATE);
        assertEquals("valor_compra", SystemConstants.PURCHASE_VALUE);
        assertEquals("serial", SystemConstants.SERIAL);
        assertEquals(10, SystemConstants.SERIAL_LENGTH);
        assertEquals("SELECT a.serial FROM Active a WHERE LOWER(a.serial) = LOWER(:serial) AND a.idActive != :id", SystemConstants.ACTIVE_SERIAL_QUERY);
    }

    @Test
    void testAnswer() {
        ReplyMessage replyMessage = new ReplyMessage();
        replyMessage.setDate(LocalDateTime.of(2024, 3, 11, 10, 30, 10));
        replyMessage.setHttpStatus(HttpStatus.OK);
        replyMessage.setError(true);
        replyMessage.setMessage(List.of("Mensaje 1", "Mensaje 2"));
        replyMessage.setObject(new Object());

        ResponseEntity<ReplyMessage> response = ResponseEntity
                .status(replyMessage.getHttpStatus())
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(replyMessage);

        assertNotNull(response);
        assertEquals(response, answer(replyMessage));
    }
}