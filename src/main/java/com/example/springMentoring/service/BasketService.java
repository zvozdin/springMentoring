package com.example.springMentoring.service;

import com.example.springMentoring.dao.BasketRepository;
import com.example.springMentoring.model.Basket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }
}
