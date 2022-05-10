package com.reservation.reservationsystem.service;

import com.reservation.reservationsystem.dto.StoreRequestDto;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.store.Store;
import com.reservation.reservationsystem.repository.CompanyRepository;
import com.reservation.reservationsystem.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CompanyRepository companyRepository;

    public void save(StoreRequestDto dto, Long companyId){
        Optional<Company> company = companyRepository.findById(companyId);

        Store store = dto.toEntity();

        company.ifPresent(s -> {
            company.get().addStore(store);
            storeRepository.save(store);
        });
    }

}
