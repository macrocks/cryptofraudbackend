package com.example.cryptofraud.repository;

import com.example.cryptofraud.model.CryptoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoDataRepository extends JpaRepository<CryptoData, Long> {
    Page<CryptoData> findAllByOrderBySubmissionTimeDesc(Pageable pageable);
}
