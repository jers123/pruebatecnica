package org.javatest.assetdepreciation.model.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.javatest.assetdepreciation.model.Depreciation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_DEPRECIATION_TYPE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_DESCRIPTION_SIZE;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_NAME_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_NAME_SIZE;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_PURCHASE_DATE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_PURCHASE_VALUE_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_SERIAL_NOT_NULL;
import static org.javatest.assetdepreciation.utils.Constants.ACTIVE_SERIAL_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActiveDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private final String errorMessage = "Mensaje de error incorrecto";
    private final String errorValidation = "Se esperan violaciones de validación";
    private ActiveDTO activeDto;

    @BeforeEach
    void setUp() {
        activeDto = new ActiveDTO();
        activeDto.setIdActivo(1);
        activeDto.setSerial("12abc3");
        activeDto.setNombre("pc de mesa");
        activeDto.setDescripcion("pc todo en uno");
        activeDto.setFechaCompra(LocalDate.now());
        activeDto.setValorCompra(2000000.0);
        activeDto.setDepreciacion(Depreciation.COMPUTADORES_OFICINA);
    }

    @Test
    void testSettersAndGetters() {
        Integer idActivo = 1;
        String serial = "12abc3";
        String nombre = "pc de mesa";
        String descripcion = "pc todo en uno";
        LocalDate fechaCompra = LocalDate.now();
        Double valorCompra = 2000000.0;
        Depreciation depreciacion = Depreciation.COMPUTADORES_OFICINA;

        activeDto.setIdActivo(idActivo);
        activeDto.setSerial(serial);
        activeDto.setNombre(nombre);
        activeDto.setDescripcion(descripcion);
        activeDto.setFechaCompra(fechaCompra);
        activeDto.setValorCompra(valorCompra);
        activeDto.setDepreciacion(depreciacion);

        assertNotNull(activeDto.getIdActivo());
        assertNotNull(activeDto.getSerial());
        assertNotNull(activeDto.getNombre());
        assertNotNull(activeDto.getDescripcion());
        assertNotNull(activeDto.getFechaCompra());
        assertNotNull(activeDto.getValorCompra());
        assertNotNull(activeDto.getDepreciacion());

        assertEquals(idActivo, activeDto.getIdActivo());
        assertEquals(serial, activeDto.getSerial());
        assertEquals(nombre, activeDto.getNombre());
        assertEquals(descripcion, activeDto.getDescripcion());
        assertEquals(fechaCompra, activeDto.getFechaCompra());
        assertEquals(valorCompra, activeDto.getValorCompra());
        assertEquals(depreciacion, activeDto.getDepreciacion());
    }

    @Test
    void testValidActiveDTO() {
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertTrue(violations.isEmpty(), "No se esperaban violaciones de validación");
    }

    @Test
    void testSerialNull() {
        activeDto.setSerial(null);
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertEquals(ACTIVE_SERIAL_NOT_NULL, message, errorMessage);
    }

    @Test
    void testSerialLength() {
        activeDto.setSerial("12345678901");
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertTrue(message.contains(ACTIVE_SERIAL_SIZE), errorMessage);
    }

    @Test
    void testNombreNull() {
        activeDto.setNombre(null);
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertEquals(ACTIVE_NAME_NOT_NULL, message, errorMessage);
    }

    @Test
    void testNombreLength() {
        activeDto.setNombre("Los computadores de mesa son potentes herramientas de computación.");
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertTrue(message.contains(ACTIVE_NAME_SIZE), errorMessage);
    }

    @Test
    void testDescripcionLength() {
        activeDto.setDescripcion("Los computadores de mesa, también conocidos como computadoras de escritorio, son dispositivos versátiles y potentes que ofrecen un rendimiento excepcional para tareas de trabajo, entretenimiento y creación de contenido, brindando una experiencia informática completa y personalizada en un formato fijo y robusto.");
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertTrue(message.contains(ACTIVE_DESCRIPTION_SIZE), errorMessage);
    }

    @Test
    void testFechaCompraNull() {
        activeDto.setFechaCompra(null);
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertEquals(ACTIVE_PURCHASE_DATE_NOT_NULL, message, errorMessage);
    }

    @Test
    void testValorCompraNull() {
        activeDto.setValorCompra(null);
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertEquals(ACTIVE_PURCHASE_VALUE_NOT_NULL, message, errorMessage);
    }

    @Test
    void testDepreciacionNull() {
        activeDto.setDepreciacion(null);
        Set<ConstraintViolation<ActiveDTO>> violations = validator.validate(activeDto);
        assertFalse(violations.isEmpty(), errorValidation);

        String message = "";
        for (ConstraintViolation<ActiveDTO> violation : violations) {
            message = violation.getMessage();
            break;
        }
        assertEquals(ACTIVE_DEPRECIATION_TYPE_NOT_NULL, message, errorMessage);
    }

    @AfterEach
    void tearDown() {
        activeDto = null;
    }
}