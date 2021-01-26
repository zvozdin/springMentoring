package com.example.springMentoring.service;

import com.example.springMentoring.dao.BasketRepository;
import com.example.springMentoring.model.Basket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    public Optional<Basket> getBasketByProductName(String name) {
        return basketRepository.findByProductName(name);
    }

    public Basket addToBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public void clearBaskets() {
        basketRepository.deleteAll();
    }
}
