package org.javatest.assetdepreciation.utils;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public final class SystemConstants {
    public static final String LOCAL_ORIGIN_PATH = "http://localhost:8080";
    public static final String ASSET_DEPRECIATION_PATH = "/assetdepreciation";
    public static final String CREATE_PATH = "/create";
    public static final String DELETE_PATH = "/delete/";
    public static final String GET_ALL_PATH = "/get-all";
    public static final String GET_ID_PATH = "/get-id/";
    public static final String UPDATE_PATH = "/update";
    protected static final String CONTENT_TYPE = "Content-Type";

    // DATABASE
    public static final String DATABASE = "test";
    public static final String SCHEMA = "public";

    //TABLE
    public static final String ACTIVE_TABLE = "activos";
    public static final String DEPRECIATION_TYPE = "tipo_depresiacion";
    public static final String DESCRIPTION = "descripcion";
    public static final int DESCRIPTION_LENGTH = 100;
    public static final String ID = "id";
    public static final String NAME = "nombre";
    public static final int NAME_LENGTH = 50;
    public static final String PURCHASE_DATE = "fecha_compra";
    public static final String PURCHASE_VALUE = "valor_compra";
    public static final String SERIAL = "serial";
    public static final int SERIAL_LENGTH = 10;
    public static final String ACTIVE_ID_QUERY = "SELECT a FROM Active a WHERE a.idActive = :" + ID;
    public static final String ACTIVE_SERIAL_QUERY = "SELECT a.serial FROM Active a WHERE LOWER(a.serial) = LOWER(:" + SERIAL + ") AND a.idActive != :" + ID;

    public SystemConstants() {

    }

    public static ResponseEntity<ReplyMessage> answer(ReplyMessage replyMessage) {
        return ResponseEntity
                .status(replyMessage.getHttpStatus())
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(replyMessage);
    }
}