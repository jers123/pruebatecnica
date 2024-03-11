package org.javatest.assetdepreciation.controller;

import jakarta.validation.Valid;
import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.javatest.assetdepreciation.utils.SystemConstants.CREATE_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.DELETE_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.GET_ALL_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.GET_ID_PATH;
import static org.javatest.assetdepreciation.utils.SystemConstants.ID;
import static org.javatest.assetdepreciation.utils.SystemConstants.UPDATE_PATH;

public interface IBaseController {
    @PostMapping(value = CREATE_PATH)
    ResponseEntity<ReplyMessage> create(@Valid @RequestBody ActiveDTO entityDto);

    @GetMapping(GET_ALL_PATH)
    ResponseEntity<ReplyMessage> getAll();

    @GetMapping(GET_ID_PATH + "{" + ID + "}")
    ResponseEntity<ReplyMessage> getById(@PathVariable(ID) Integer id);

    @PutMapping(UPDATE_PATH)
    ResponseEntity<ReplyMessage> update(@Valid @RequestBody ActiveDTO entityDto);

    @DeleteMapping(DELETE_PATH + "{" + ID + "}")
    ResponseEntity<ReplyMessage> delete(@PathVariable(ID) Integer id);
}