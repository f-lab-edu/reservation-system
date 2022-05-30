package com.reservation.reservationsystem.entity.store;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.menu.Menu;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.contstants.StoreCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "store")
@Builder
public class Store extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false, updatable = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreCategory category;

    @Setter
    @Column(length = 80)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_time_id")
    private List<OperationTime> operationTimes = new ArrayList<>();

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private Set<Menu> menus = new HashSet<>();

    @Tolerate
    public Store() {}

    public static Store of (
            String name,
            StoreCategory storeCategory,
            String description,
            Location location,
            Address address,
            String phoneNumber
    ){
        return builder()
                .name(name)
                .category(storeCategory)
                .description(description)
                .location(location)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }

    public void addMenu(Menu menu) {
        if (menu == null) {
            throw new NullPointerException();
        }

        if (menus == null) {
            this.menus = new HashSet<>();
        }
        this.menus.add(menu);
    }
  
    public void setCompany(Company company){
        if (this.company != null) {
            this.company.getStores().remove(this);
        }
        this.company = company;
        if(!company.getStores().contains(this)) {
            company.getStores().add(this);
        }
    }

}
