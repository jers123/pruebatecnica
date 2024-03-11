package org.javatest.assetdepreciation.service;

import org.javatest.assetdepreciation.model.dto.ActiveDTO;
import org.javatest.assetdepreciation.utils.ReplyMessage;
import org.springframework.transaction.annotation.Transactional;

public interface IBaseService {
    @Transactional()
    ReplyMessage getCreate(ActiveDTO entityDto);

    @Transactional(readOnly = true)
    ReplyMessage getFindAll();

    @Transactional(readOnly = true)
    ReplyMessage getFindById(Integer id);

    @Transactional()
    ReplyMessage getUpdate(ActiveDTO entityDto);

    @Transactional()
    ReplyMessage getDelete(Integer id);
}