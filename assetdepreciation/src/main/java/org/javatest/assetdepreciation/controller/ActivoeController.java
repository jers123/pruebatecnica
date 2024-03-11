package org.javatest.assetdepreciation.controller;

import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.service.ActiveService;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.javatest.assetdepreciation.utils.SystemConstants.ASSET_DEPRECIATION_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.LOCAL_ORIGIN_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.answer;

@RestController
@CrossOrigin(origins = {LOCAL_ORIGIN_PATH,
        "*"
    }
    ,methods = {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
    }
)
@RequestMapping(path = ASSET_DEPRECIATION_PATH)
@Validated

public class ActivoeController implements IBaseController {

    @Autowired
    private ActiveService service;

    @Override
    public ResponseEntity<ReplyMessage> create(ActiveDTO entityDto) {
        try {
            return answer(service.getCreate(entityDto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ReplyMessage> getAll() {
        try {
            return answer(service.getFindAll());
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ReplyMessage> getById(Integer id) {
        try {
            return answer(service.getFindById(id));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ReplyMessage> update(ActiveDTO entityDto) {
        try {
            return answer(service.getUpdate(entityDto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ReplyMessage> delete(Integer id) {
        try {
            return answer(service.getDelete(id));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}