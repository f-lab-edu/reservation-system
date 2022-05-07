<<<<<<< HEAD:src/main/java/com/reservation/reservationsystem/entity/store/Store.java
package com.reservation.reservationsystem.entity.store;

import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.contstants.StoreCategory;
=======
package entity.store;

import entity.*;
import entity.Address;
import entity.Company;
import entity.Location;
import entity.OperationTime;
import entity.StoreCategory;
>>>>>>> 3a3ffa0 (OperationTime 수정):src/main/java/entity/store/Store.java
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

<<<<<<< HEAD:src/main/java/com/reservation/reservationsystem/entity/store/Store.java
    @Setter
    @Column(nullable = false, name="phone_number")
    private String phoneNumber;
=======
    @Column(nullable = false)
    private String phonenumber;
>>>>>>> 3a3ffa0 (OperationTime 수정):src/main/java/entity/store/Store.java

    @OneToMany
    @JoinColumn(name = "operation_time_id")
    private List<OperationTime> operationTimes = new ArrayList<>();

    public Store() {}

    @Builder
    public Store of (
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
