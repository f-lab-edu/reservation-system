package com.reservation.reservationsystem.controller;
import com.reservation.reservationsystem.dto.StoreRequestDto;
import com.reservation.reservationsystem.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/stores")
    public ResponseEntity save(@PathVariable String email ,@RequestBody StoreRequestDto dto) {
        return ResponseEntity.ok(storeService.save(dto, email));
    }

}
