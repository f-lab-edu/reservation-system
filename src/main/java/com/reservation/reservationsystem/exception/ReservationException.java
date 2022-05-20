package com.reservation.reservationsystem.exception;

public class ReservationException extends RuntimeException {

    private static final long serialVersionUID = 7165230430080844303L;

    public ReservationException(String errorMessage) {
        super(errorMessage);
    }
}
