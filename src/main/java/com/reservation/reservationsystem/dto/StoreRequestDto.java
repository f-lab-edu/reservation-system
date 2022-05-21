package com.reservation.reservationsystem.dto;

import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.contstants.StoreCategory;
import com.reservation.reservationsystem.entity.store.Address;
import com.reservation.reservationsystem.entity.store.Location;
import com.reservation.reservationsystem.entity.store.OperationTime;
import com.reservation.reservationsystem.entity.store.Store;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class StoreRequestDto {

    @NotBlank(message = "이름을 작성해주세요.")
    private String name;

    private StoreCategory category;
    private String description;
    private Address address;
    private Location location;

    @Pattern(regexp = "^\\d{10}$", message = "11자리의 숫자만 입력 가능합니다.")
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
