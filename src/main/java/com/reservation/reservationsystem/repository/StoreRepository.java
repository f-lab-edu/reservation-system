package com.reservation.reservationsystem.repository;
import com.reservation.reservationsystem.entity.store.Store;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StoreRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Store store){
        em.persist(store);
    }

    public Store findByStoreId(Long id){
        return em.find(Store.class, id);
    }

}
