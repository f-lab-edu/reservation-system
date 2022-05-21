package com.reservation.reservationsystem.controller;

import com.reservation.reservationsystem.exception.CustomException;
import com.reservation.reservationsystem.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getCode();
        return ResponseEntity.status(errorCode.getStatus()).body(errorCode.getMessage());
    }
}
