package com.reservation.reservationsystem.entity.reservation;

import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.contstants.PaymentType;
import com.reservation.reservationsystem.entity.contstants.ReservationStatus;
import com.reservation.reservationsystem.entity.customer.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Builder
@Table(name = "reservation")
public class Reservation extends Audit {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @Setter
    @Enumerated(STRING)
    @Column(length = 40, nullable = false)
    private ReservationStatus reservationStatus; // todo:: default type 지정할 것

    @Column(length = 10, nullable = false)
    private Long amount;

    @Setter
    @Enumerated(STRING)
    @Column(length = 40, nullable = false)
    private PaymentType paymentType; // todo:: default type 지정할 것

    @Setter
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private LocalDateTime reservedDate;

    @Column(nullable = false)
    private LocalDateTime reservedTime;

    @Column(nullable = false)
    private int numberOfCustomer = 1 ;

    @OneToOne
    @JoinColumn(name = "review_id", nullable = true)
    private Review review;

    @Tolerate
    public Reservation() {}

    public static Reservation of(
            Customer customer,
            ReservationStatus reservationStatus,
            long amount,
            PaymentType paymentType,
            LocalDateTime paymentDate,
            LocalDateTime reservedDate,
            LocalDateTime reservedTime,
            int numberOfCustomer
    ) {
        return builder()
                .customer(customer)
                .reservationStatus(reservationStatus)
                .amount(amount)
                .paymentType(paymentType)
                .paymentDate(paymentDate)
                .reservedDate(reservedDate)
                .reservedTime(reservedTime)
                .numberOfCustomer(numberOfCustomer)
                .build();
    }
}