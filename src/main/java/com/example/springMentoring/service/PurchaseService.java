package com.example.springMentoring.service;

import com.example.springMentoring.dao.PurchaseRepository;
import com.example.springMentoring.model.Basket;
import com.example.springMentoring.model.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PurchaseService {

    private final BasketService basketService;
    private final PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Transactional
    public Purchase doPurchase() {
        Purchase save = purchaseRepository.save(getPurchase());

        basketService.clearBaskets();

        return save;
    }

    private Purchase getPurchase() {
        List<Basket> baskets = basketService.getAllBaskets();

        // todo if size == 0 throw empty basket

        Purchase purchase = new Purchase();
        purchase.setPrice(baskets.stream()
                .mapToDouble(Basket::getPrice)
                .sum());
        purchase.setUser(baskets.stream()
                .map(Basket::getUser)
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("doesn't exist from purchase service")));
        return purchase;
    }
}
