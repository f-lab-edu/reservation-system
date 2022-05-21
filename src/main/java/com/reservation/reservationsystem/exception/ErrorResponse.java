package com.reservation.reservationsystem.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public ErrorResponse(ErrorCode code){
        this.status = code.getStatus().value();
        this.error = code.getStatus().name();
        this.code = code.name();
        this.message = code.getMessage();
    }
}
