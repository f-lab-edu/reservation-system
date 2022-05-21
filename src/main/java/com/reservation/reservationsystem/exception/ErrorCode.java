package com.reservation.reservationsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    COMPANY_NOT_FOUND(HttpStatus.NOT_FOUND, "등록된 company를 찾을 수 없습니다.")
    ;

    private final HttpStatus status;
    private final String message;

}