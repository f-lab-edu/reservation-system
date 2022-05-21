package com.reservation.reservationsystem.service;

import com.reservation.reservationsystem.dto.StoreRequestDto;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.entity.store.Store;
import com.reservation.reservationsystem.exception.CustomException;
import com.reservation.reservationsystem.exception.ErrorCode;
import com.reservation.reservationsystem.repository.CompanyRepository;
import com.reservation.reservationsystem.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public Long save(Long companyId, StoreRequestDto dto) {
        System.out.println(companyId);
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CustomException(ErrorCode.COMPANY_NOT_FOUND));
        Store store = dto.toEntity();
        store.setCompany(company);
        storeRepository.save(store);

        return store.getId();
    }
}
