package com.reservation.reservationsystem.controller;

import com.reservation.reservationsystem.exception.ReservationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<String> handleCustomException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
