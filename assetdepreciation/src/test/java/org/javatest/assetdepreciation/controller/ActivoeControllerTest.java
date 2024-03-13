package org.javatest.assetdepreciation.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.javatest.assetdepreciation.model.Depreciation;
import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.service.ActiveService;
import org.javatest.assetdepreciation.utils.LocalDateAdapter;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Collections.singletonList;
import static org.javatest.assetdepreciation.utils.Constants.SUCCESSFULLY_CREATED_ACTIVE;
import static org.javatest.assetdepreciation.utils.SystemConstants.ASSET_DEPRECIATION_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.CREATE_PATH;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ActivoeController.class)
class ActivoeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActiveService service;

    @MockBean
    private ReplyMessage replyMessage;

    @Test
    public void testCreateActive_Success() throws Exception {
        ActiveDTO activeDto = createActiveDTO();
        ReplyMessage response = new ReplyMessage();
        response.setDate(LocalDateTime.now());
        response.setHttpStatus(HttpStatus.CREATED);
        response.setError(false);
        response.setMessage(singletonList(SUCCESSFULLY_CREATED_ACTIVE));

        when(service.getCreate(activeDto)).thenReturn(response);

        mockMvc.perform(post(ASSET_DEPRECIATION_PATH + CREATE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(activeDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.httpStatus").value(HttpStatus.CREATED))
                .andExpect(jsonPath("$.error").isBoolean())
                .andExpect(jsonPath("$.error").value(false))
                .andExpect(jsonPath("$.message[0]").value(SUCCESSFULLY_CREATED_ACTIVE));
    }

    private String asJsonString(ActiveDTO activeDto) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        return gson.toJson(activeDto);
    }

    private ActiveDTO createActiveDTO() {
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
}