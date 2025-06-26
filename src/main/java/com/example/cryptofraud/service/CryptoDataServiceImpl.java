package com.example.cryptofraud.service;

import com.example.cryptofraud.dto.CryptoDataDto;
import com.example.cryptofraud.dto.PaginatedResponse;
import com.example.cryptofraud.model.CryptoData;
import com.example.cryptofraud.repository.CryptoDataRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CryptoDataServiceImpl{

    private final CryptoDataRepository cryptoDataRepository;

    public CryptoDataServiceImpl(CryptoDataRepository cryptoDataRepository) {
        this.cryptoDataRepository = cryptoDataRepository;
    }

    
    public CryptoData saveCryptoData(CryptoDataDto cryptoDataDto) {
        CryptoData cryptoData = new CryptoData();
        cryptoData.setName(cryptoDataDto.getName());
        cryptoData.setEmail(cryptoDataDto.getEmail());
        cryptoData.setCode(cryptoDataDto.getCode());
        
        return cryptoDataRepository.save(cryptoData);
    }

  
    public PaginatedResponse getLatestCryptoData(Pageable pageable) {
        Page<CryptoData> page = cryptoDataRepository.findAllByOrderBySubmissionTimeDesc(pageable);
        return new PaginatedResponse(page);
    }
}
