package com.reservation.reservationsystem.service;

import com.reservation.reservationsystem.entity.store.Store;
import com.reservation.reservationsystem.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public void saveStore(Store store){
        storeRepository.save(store);
    }

    public void findByStoreId(Long id){
        storeRepository.findById();
    }

}
