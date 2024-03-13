package org.javatest.assetdepreciation.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReplyMessageTest {

    @Test
    void testSettersAndGetters() {
        ReplyMessage replyMessage = new ReplyMessage();

        LocalDateTime date = LocalDateTime.now();
        HttpStatus httpStatus = HttpStatus.OK;
        Boolean error = true;
        List<String> message = List.of("Mensaje 1", "Mensaje 2");
        Object object = new Object();

        replyMessage.setDate(date);
        replyMessage.setHttpStatus(httpStatus);
        replyMessage.setError(error);
        replyMessage.setMessage(message);
        replyMessage.setObject(object);

        assertNotNull(replyMessage.getDate());
        assertNotNull(replyMessage.getHttpStatus());
        assertNotNull(replyMessage.getError());
        assertNotNull(replyMessage.getMessage());
        assertNotNull(replyMessage.getObject());

        assertEquals(date, replyMessage.getDate());
        assertEquals(httpStatus, replyMessage.getHttpStatus());
        assertEquals(error, replyMessage.getError());
        assertEquals(message, replyMessage.getMessage());
        assertEquals(object, replyMessage.getObject());
    }
}