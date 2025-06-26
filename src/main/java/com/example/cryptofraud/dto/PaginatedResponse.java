package com.example.cryptofraud.dto;

import com.example.cryptofraud.model.CryptoData;
import org.springframework.data.domain.Page;

import java.util.List;

public class PaginatedResponse {
    private List<CryptoData> data;
    private int currentPage;
    private long totalItems;
    private int totalPages;

    public PaginatedResponse(Page<CryptoData> page) {
        this.data = page.getContent();
        this.currentPage = page.getNumber();
        this.totalItems = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    // Getters
    public List<CryptoData> getData() {
        return data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
