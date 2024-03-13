package org.javatest.assetdepreciation.model.entity;

import org.javatest.assetdepreciation.model.Depreciation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ActiveTest {
    @Test
    public void testSettersAndGetter() {
        Active active = new Active();

        Integer idActive = 1;
        String serial = "12abc3";
        String name = "pc de mesa";
        String description = "pc todo en uno";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseValue = 2000000.0;
        Depreciation depreciationType = Depreciation.COMPUTADORES_OFICINA;

        active.setIdActive(idActive);
        active.setSerial(serial);
        active.setName(name);
        active.setDescription(description);
        active.setPurchaseDate(purchaseDate);
        active.setPurchaseValue(purchaseValue);
        active.setDepreciationType(depreciationType);

        assertNotNull(active.getIdActive());
        assertNotNull(active.getSerial());
        assertNotNull(active.getName());
        assertNotNull(active.getDescription());
        assertNotNull(active.getPurchaseDate());
        assertNotNull(active.getPurchaseValue());
        assertNotNull(active.getDepreciationType());

        assertEquals(idActive, active.getIdActive());
        assertEquals(serial, active.getSerial());
        assertEquals(name, active.getName());
        assertEquals(description, active.getDescription());
        assertEquals(purchaseDate, active.getPurchaseDate());
        assertEquals(purchaseValue, active.getPurchaseValue());
        assertEquals(depreciationType, active.getDepreciationType());
    }
}