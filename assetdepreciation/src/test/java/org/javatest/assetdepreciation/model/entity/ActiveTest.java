package org.javatest.assetdepreciation.model.entity;

import org.javatest.assetdepreciation.model.Depreciation;
import org.javatest.assetdepreciation.model.repository.ActiveRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestMethodOrder(OrderAnnotation.class)
class ActiveTest {

    @Autowired
    private ActiveRepository repository;

    private Active active;

    @BeforeEach
    void setUp() {
        active = new Active();
        active.setSerial("12abc3");
        active.setName("pc de mesa");
        active.setDescription("pc todo en uno");
        active.setPurchaseDate(LocalDate.now());
        active.setPurchaseValue(2000000.0);
        active.setDepreciationType(Depreciation.COMPUTADORES_OFICINA);
    }

    @Test
    @Order(2)
    public void testSettersAndGetters() {
        Integer idActive = 1;
        String serial = "12abc3";
        String name = "pc de mesa";
        String description = "pc todo en uno";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseValue = 2000000.0;
        Depreciation depreciationType = Depreciation.COMPUTADORES_OFICINA;

        active = new Active();
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

    @Test
    @Order(3)
    void testSave() {
        Active activeSave = repository.save(active);

        assertNotNull(activeSave);
        assertNotNull(activeSave.getIdActive());
        assertNotNull(activeSave.getSerial());
        assertNotNull(activeSave.getName());
        assertNotNull(activeSave.getDescription());
        assertNotNull(activeSave.getPurchaseDate());
        assertNotNull(activeSave.getPurchaseValue());
        assertNotNull(activeSave.getDepreciationType());

        assertEquals(active.getSerial(), activeSave.getSerial());
        assertEquals(active.getName(), activeSave.getName());
        assertEquals(active.getDescription(), activeSave.getDescription());
        assertEquals(active.getPurchaseDate(), activeSave.getPurchaseDate());
        assertEquals(active.getPurchaseValue(), activeSave.getPurchaseValue());
        assertEquals(active.getDepreciationType(), activeSave.getDepreciationType());
    }

    @Test
    @Order(4)
    void testFindAll() {
        active = repository.save(active);

        List<Active> actives = repository.findAll();

        for (Active active1: actives) {
            System.out.println(active1.toString());
        }
        assertThat(actives.size()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    void testSearchById() {
        Integer idActive = 1;
        active = repository.save(active);
        active = repository.searchById(active.getIdActive());

        assertNotNull(active);
        assertThat(active.getIdActive()).isEqualTo(idActive);
    }

    @Test
    @Order(5)
    void testSearchBySerial() {
        String serial = "12abc3";
        active = repository.save(active);
        String activeSerial = repository.searchBySerial(0, serial);

        assertNotNull(activeSerial);
        assertThat(activeSerial).isEqualTo(serial);
    }

    @Test
    @Order(6)
    void testSearchBySerialNotExists() {
        String serial = "abc123";
        active = repository.save(active);
        String activeSerial = repository.searchBySerial(0, serial);

        assertNull(activeSerial);
    }

    @Test
    @Order(7)
    void testUpdate() {
        active = repository.save(active);

        String serial = "abc123";
        String name = "mesa";
        String description = "Escritorio para computador";
        LocalDate purchaseDate = LocalDate.now();
        Double purchaseValue = 400000.0;
        Depreciation depreciationType = Depreciation.MUEBLES_ENSERES;

        active.setIdActive(active.getIdActive());
        active.setSerial(serial);
        active.setName(name);
        active.setDescription(description);
        active.setPurchaseDate(purchaseDate);
        active.setPurchaseValue(purchaseValue);
        active.setDepreciationType(depreciationType);
        repository.save(active);

        Active activeSave = repository.searchById(active.getIdActive());

        assertEquals(active.getIdActive(), activeSave.getIdActive());
        assertEquals(serial, activeSave.getSerial());
        assertEquals(name, activeSave.getName());
        assertEquals(description, activeSave.getDescription());
        assertEquals(purchaseDate, activeSave.getPurchaseDate());
        assertEquals(purchaseValue, activeSave.getPurchaseValue());
        assertEquals(depreciationType, activeSave.getDepreciationType());
    }

    @Test
    @Order(8)
    void testDelete() {
        active = repository.save(active);

        boolean exist = repository.findById(active.getIdActive()).isPresent();
        assertTrue(exist);
        repository.deleteById(active.getIdActive());
        exist = repository.findById(active.getIdActive()).isPresent();
        assertFalse(exist);
    }

    @AfterEach
    void tearDown() {
        active = null;
    }
}