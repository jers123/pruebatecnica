package org.javatest.assetdepreciation.service;

import org.javatest.assetdepreciation.model.Depreciation;
import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.model.dto.ActiveResult;
import org.javatest.assetdepreciation.model.dto.Depreciacion;
import org.javatest.assetdepreciation.model.dto.DepresiationType;
import org.javatest.assetdepreciation.model.entity.Active;
import org.javatest.assetdepreciation.model.repository.ActiveRepository;
import org.javatest.assetdepreciation.utils.ActiveMapper;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.javatest.assetdepreciation.utils.Constants.SUCCESSFULLY_CREATED_ACTIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
class ActiveServiceTest {
    @Autowired
    private ActiveService activeService;

    @Mock
    private ActiveRepository repository;

    @Mock
    private ActiveMapper mapper;

    @Mock
    private ReplyMessage replyMessage;

    @Test
    public void testCreateActive() {
        ActiveDTO activeDto = getActiveDTO();
        Active active = getActive();
        ActiveResult activeResult = getActiveResult();

        when(repository.searchBySerial(0, activeDto.getSerial())).thenReturn(null);
        when(mapper.create(activeDto)).thenReturn(active);
        when(mapper.read(repository.save(active))).thenReturn(activeResult);

        ReplyMessage replyMessage = activeService.getCreate(activeDto);

        assertNotNull(replyMessage.getDate());
        assertEquals(HttpStatus.CREATED, replyMessage.getHttpStatus());
        assertFalse(replyMessage.getError());
        assertEquals(SUCCESSFULLY_CREATED_ACTIVE, replyMessage.getMessage().get(0));
        assertNotNull(replyMessage.getObject());
    }



    // Similar tests can be created for getFindAll, getFindById, getUpdate, and getDelete methods.

    private ActiveDTO getActiveDTO() {
        ActiveDTO activeDto = new ActiveDTO();
        activeDto.setIdActivo(1);
        activeDto.setSerial("12abc3");
        activeDto.setNombre("pc de mesa");
        activeDto.setDescripcion("pc todo en uno");
        activeDto.setFechaCompra(LocalDate.now());
        activeDto.setValorCompra(2000000.0);
        activeDto.setDepreciacion(Depreciation.COMPUTADORES_OFICINA);
        return activeDto;
    }

    private Active getActive() {
        Active active = new Active();
        active.setIdActive(1);
        active.setSerial("12abc3");
        active.setName("pc de mesa");
        active.setDescription("pc todo en uno");
        active.setPurchaseDate(LocalDate.now());
        active.setPurchaseValue(2000000.0);
        active.setDepreciationType(Depreciation.COMPUTADORES_OFICINA);
        return active;
    }

    private ActiveResult getActiveResult() {
        DepresiationType depreciationType = new DepresiationType();
        depreciationType.setTipoActivo("Computadores y equipos de oficina");
        depreciationType.setVidaUtil(5);
        depreciationType.setPorcentajeAnual(20.0);
        List<Depreciacion> depreciaciones = new ArrayList<>();
        Depreciacion depreciacions = new Depreciacion();
        depreciacions.setAnioNumero(1);
        depreciacions.setFecha(LocalDate.now().plusYears(1));
        depreciacions.setValorDepreciacion(1600000.0);
        depreciaciones.add(depreciacions);

        ActiveResult activeResult = new ActiveResult();
        activeResult.setIdActivo(1);
        activeResult.setSerial("12abc3");
        activeResult.setNombre("pc de mesa");
        activeResult.setDescripcion("pc todo en uno");
        activeResult.setFechaCompra(LocalDate.now());
        activeResult.setValorCompra(2000000.0);
        activeResult.setDepreciacion(Depreciation.COMPUTADORES_OFICINA);
        activeResult.setTipoDepreciacion(depreciationType);
        activeResult.setDepreciaciones(depreciaciones);
        return activeResult;
    }
}