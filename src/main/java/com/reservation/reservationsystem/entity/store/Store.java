package com.reservation.reservationsystem.entity.store;

import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.contstants.StoreCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "store")
public class Store extends Audit {

    @Id @GeneratedValue
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(nullable = false, name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreCategory category;

    @Setter
    private String description;

    @Column(nullable = false)
    @Embedded
    private Address address;

    @Embedded
    @Column(nullable = false)
    private Location location;

    @Setter
    @Column(nullable = false, name="phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "operation_time_id")
    private List<OperationTime> operationTimes = new ArrayList<>();

    public Store() {}

    @Builder
    public static Store of(
            String name,
            StoreCategory storeCategory,
            String description,
            Location location,
            Address address,
            OperationTime operationTime,
            String phoneNumber
    ){
        return builder()
                .name(name)
                .storeCategory(storeCategory)
                .description(description)
                .location(location)
                .address(address)
                .operationTime(operationTime)
                .phoneNumber(phoneNumber)
                .build();
    }
}
