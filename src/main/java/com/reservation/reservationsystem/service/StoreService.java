package com.reservation.reservationsystem.service;

import com.reservation.reservationsystem.dto.StoreRequestDto;
import com.reservation.reservationsystem.entity.company.Company;
import com.reservation.reservationsystem.repository.CompanyRepository;
import com.reservation.reservationsystem.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CompanyRepository companyRepository;

    public long save(StoreRequestDto dto, String email){
        Company company = companyRepository.getEmail();
        //to do:: 이메일로 company 찾아서 같이 서비스로 넘겨줘야함.....
        return storeRepository.save(dto.toEntity()).getId();
    }


}
