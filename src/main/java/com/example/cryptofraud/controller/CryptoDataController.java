package com.example.cryptofraud.controller;

import com.example.cryptofraud.dto.CryptoDataDto;
import com.example.cryptofraud.dto.PaginatedResponse;
import com.example.cryptofraud.model.CryptoData;
import com.example.cryptofraud.service.CryptoDataServiceImpl;

import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CryptoDataController {

    private final CryptoDataServiceImpl cryptoDataService;

    public CryptoDataController(CryptoDataServiceImpl cryptoDataService) {
        this.cryptoDataService = cryptoDataService;
    }

    @PostMapping("/submit")
    public ResponseEntity<CryptoData> submitCryptoData(@Valid @RequestBody CryptoDataDto cryptoDataDto) {
        CryptoData savedData = cryptoDataService.saveCryptoData(cryptoDataDto);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public ResponseEntity<PaginatedResponse> showLatestCryptoData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        PaginatedResponse response = cryptoDataService.getLatestCryptoData(pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
