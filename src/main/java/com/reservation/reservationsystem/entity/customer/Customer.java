package com.reservation.reservationsystem.entity.customer;

import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.reservation.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "customer")
public class Customer extends Audit {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @Column(length = 65, nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    @Tolerate
    public Customer() {}

    public static Customer of (
            String name,
            String email,
            String phoneNumber,
            String password
    ) {
        return builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
    }

    public void addReservation(Reservation reservation) {
        if (reservation == null) {
            throw new EntityExistsException();
        }
        if (reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(reservation);
    }
}

