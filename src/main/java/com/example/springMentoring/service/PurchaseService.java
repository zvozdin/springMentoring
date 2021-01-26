package com.example.springMentoring.service;

import com.example.springMentoring.dao.PurchaseRepository;
import com.example.springMentoring.model.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase addToPurchases(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
