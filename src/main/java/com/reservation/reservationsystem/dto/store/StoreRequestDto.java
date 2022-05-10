package com.reservation.reservationsystem.dto.store;

import com.reservation.reservationsystem.entity.contstants.StoreCategory;
import com.reservation.reservationsystem.entity.store.Address;
import com.reservation.reservationsystem.entity.store.Location;
import com.reservation.reservationsystem.entity.store.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreRequestDto {

    private String name;
    private StoreCategory category;
    private String description;
    private Address address;
    private Location location;
    private String phoneNumber;

    @Builder
    public StoreRequestDto (String name, StoreCategory category,
                            String description,Address address,Location location,
                            String phoneNumber){
        this.name = name;
        this.category = category;
        this.description = description;
        this.address = address;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Store toEntity() {
        return Store.of(name, category, description, location, address, phoneNumber);
    }

}
