package com.reservation.reservationsystem.entity.company;

import com.reservation.reservationsystem.entity.Audit;
import com.reservation.reservationsystem.entity.store.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@Table(name = "company")
public class Company extends Audit {
    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    @Column(length = 13, nullable = false)
    private String businessNumber;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @NotNull // email validation 조건 추가
    private String email;

    @OneToMany(targetEntity = Store.class, cascade = CascadeType.ALL)
    private Set<Store> stores = new HashSet<>();

    @Tolerate
    public Company() {}

    public void addStore(Store store) {
        if (store == null) {
            throw new NullPointerException();
        }

        if (store == null) {
            this.stores = new HashSet<>();
        }
        this.stores.add(store);
    }

}
