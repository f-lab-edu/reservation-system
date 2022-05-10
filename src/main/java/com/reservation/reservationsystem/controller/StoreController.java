package com.reservation.reservationsystem.controller;
import com.reservation.reservationsystem.dto.StoreRequestDto;
import com.reservation.reservationsystem.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/stores/{id}")
    public ResponseEntity.BodyBuilder save(@PathVariable("id") Long companyId, @Valid @RequestBody StoreRequestDto dto) {
        this.storeService.save(dto, companyId);
        return ResponseEntity.ok();
    }

}
