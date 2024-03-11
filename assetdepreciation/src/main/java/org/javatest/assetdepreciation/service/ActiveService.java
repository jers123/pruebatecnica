package org.javatest.assetdepreciation.service;

import org.javatest.assetdepreciation.model.dto.*;
import org.javatest.assetdepreciation.model.entity.Active;
import org.javatest.assetdepreciation.model.repository.ActiveRepository;
import org.javatest.assetdepreciation.utils.ActiveMapper;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.javatest.assetdepreciation.utils.Constants.*;

@Service
@Validated
public class ActiveService implements IBaseService {

    @Autowired
    private ActiveRepository repository;

    @Autowired
    private ReplyMessage replyMessage;

    @Autowired
    private ActiveMapper mapper;

    @Override
    public ReplyMessage getCreate(ActiveDTO entityDto) {
        replyMessage.setError(true);
        replyMessage.setObject(null);
        List<String> messages = new ArrayList<>();
        try {
            String serial = repository.searchBySerial(0, entityDto.getSerial());
            if (serial == null) {
                Active entity = mapper.create(entityDto);
                ActiveResult entityresult = mapper.read(repository.save(entity));
                entityresult.setDepresiaciones(getDepreciation(entityresult));
                replyMessage.setHttpStatus(HttpStatus.CREATED);
                replyMessage.setError(false);
                messages.add(SUCCESSFULLY_CREATED_ACTIVE);
                replyMessage.setObject(entityresult);
            } else {
                replyMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
                messages.add(ACTIVE_SERIAL_EXISTS);
            }
        } catch (Exception e) {
            replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            messages.add(e.getMessage());
        }
        replyMessage.setMessage(messages);
        replyMessage.setDate(LocalDateTime.now());
        return replyMessage;
    }

    @Override
    public ReplyMessage getFindAll() {
        replyMessage.setError(true);
        replyMessage.setObject(null);
        List<String> messages = new ArrayList<>();
        try {
            List<Active> entities = repository.findAll();
            if (!entities.isEmpty()) {
                List<ActiveResults> entitiesDto = new ArrayList<>();
                for (Active entity : entities) {
                    entitiesDto.add(mapper.readAll(entity));
                }
                messages.add(YES_CONTENT);
                replyMessage.setObject(entitiesDto);
            } else {
                messages.add(NO_CONTENT);
            }
            replyMessage.setHttpStatus(HttpStatus.OK);
            replyMessage.setError(false);
        } catch (Exception e) {
            replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            messages.add(e.getMessage());
        }
        replyMessage.setMessage(messages);
        replyMessage.setDate(LocalDateTime.now());
        return replyMessage;
    }

    @Override
    public ReplyMessage getFindById(Integer id) {
        replyMessage.setError(true);
        replyMessage.setObject(null);
        List<String> messages = new ArrayList<>();
        try {
            Active entity = repository.findById(id).orElse(null);
            if (entity != null) {
                ActiveResult entityDto = mapper.read(entity);
                entityDto.setDepresiaciones(getDepreciation(entityDto));
                replyMessage.setHttpStatus(HttpStatus.OK);
                replyMessage.setError(false);
                messages.add(YES_CONTENT);
                replyMessage.setObject(entityDto);
            } else {
                replyMessage.setHttpStatus(HttpStatus.NOT_FOUND);
                messages.add(NO_CONTENT_ID + id);
            }
        } catch (Exception e) {
            replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            messages.add(e.getMessage());
        }
        replyMessage.setMessage(messages);
        replyMessage.setDate(LocalDateTime.now());
        return replyMessage;
    }

    @Override
    public ReplyMessage getUpdate(ActiveDTO entityDto) {
        replyMessage.setError(true);
        replyMessage.setObject(null);
        List<String> messages = new ArrayList<>();
        try {
            Active entity = repository.findById(entityDto.getIdActivo()).orElse(null);
            if (entity != null) {
                String serial = repository.searchBySerial(entityDto.getIdActivo(), entityDto.getSerial());
                if (serial == null) {
                    entity = mapper.update(entityDto, entity);
                    ActiveResult entityresult = mapper.read(repository.save(entity));
                    entityresult.setDepresiaciones(getDepreciation(entityresult));
                    replyMessage.setHttpStatus(HttpStatus.CREATED);
                    replyMessage.setError(false);
                    messages.add(SUCCESSFULLY_UPDATED_ACTIVE);
                    replyMessage.setObject(entityresult);
                } else {
                    replyMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
                    messages.add(ACTIVE_SERIAL_EXISTS);
                }
            } else {
                replyMessage.setHttpStatus(HttpStatus.NOT_FOUND);
                messages.add(NO_CONTENT_ID + entityDto.getIdActivo());
            }
        } catch (Exception e) {
            replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            messages.add(e.getMessage());
        }
        replyMessage.setMessage(messages);
        replyMessage.setDate(LocalDateTime.now());
        return replyMessage;
    }

    @Override
    public ReplyMessage getDelete(Integer id) {
        replyMessage.setError(true);
        replyMessage.setObject(null);
        List<String> messages = new ArrayList<>();
        try {
            Active entity = repository.findById(id).orElse(null);
            if (entity != null) {
                repository.delete(entity);
                replyMessage.setHttpStatus(HttpStatus.OK);
                replyMessage.setError(false);
                messages.add(SUCCESSFULLY_DELETED_ACTIVE);
            } else {
                replyMessage.setHttpStatus(HttpStatus.NOT_FOUND);
                messages.add(NO_CONTENT_ID + id);
            }
        } catch (Exception e) {
            replyMessage.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            messages.add(e.getMessage());
        }
        replyMessage.setMessage(messages);
        replyMessage.setDate(LocalDateTime.now());
        return replyMessage;
    }

    private List<Depreciacion> getDepreciation(ActiveResult entityDto) {
        List<Depreciacion> depreciaciones = new ArrayList<>();
        int usefulLife = entityDto.getTipoDepresiacion().getVidaUtil();
        Depreciacion depreciacion;
        LocalDate date = entityDto.getFechaCompra();
        Double depresiationValue = entityDto.getValorCompra();
        Double percentage = depresiationValue * (entityDto.getTipoDepresiacion().getPorsentajeAnual() /100);
        for(int i = 1; i <= usefulLife; i++) {
            depreciacion = new Depreciacion();
            depreciacion.setAnioNumero(i);
            date = date.plusYears(1);
            depreciacion.setFecha(date);
            depresiationValue = depresiationValue - percentage;
            depreciacion.setValorDepresiacion(Math.round(depresiationValue * 100) / 100.0);
            depreciaciones.add(depreciacion);
        }
        return depreciaciones;
    }
}