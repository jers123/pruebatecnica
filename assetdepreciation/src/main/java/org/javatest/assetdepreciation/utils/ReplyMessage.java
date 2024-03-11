package org.javatest.assetdepreciation.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Component
public class ReplyMessage {
    private LocalDateTime date;
    private HttpStatus httpStatus;
    private Boolean error;
    private List<String> message;
    private Object object;
}