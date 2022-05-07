package com.reservation.reservationsystem.dto;


import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.contstants.StoreCategory;
import com.reservation.reservationsystem.entity.store.Address;
import com.reservation.reservationsystem.entity.store.Location;
import com.reservation.reservationsystem.entity.store.OperationTime;
import com.reservation.reservationsystem.entity.store.Store;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class StoreRequestDto {

    private String name;
    private Company company;
    private StoreCategory category;
    private String description;
    private Address address;
    private Location location;
    private String phoneNumber;
    private OperationTime operationTimes;

    @Builder
    public StoreRequestDto (String name, Company company, StoreCategory category,
                            String description,Address address,Location location,
                            String phoneNumber,OperationTime operationTimes){
        this.name = name;
        this.company = company;
        this.category = category;
        this.description = description;
        this.address = address;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.operationTimes = operationTimes;
    }

    public Store toEntity() {
        return Store.of(name, category, description, location, address, operationTimes, phoneNumber);
    }

}ß
