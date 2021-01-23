package com.example.springMentoring.dao;

import com.example.springMentoring.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Optional<Basket> findByProductName(String name);
}
