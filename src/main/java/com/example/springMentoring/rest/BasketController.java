package com.example.springMentoring.rest;

import com.example.springMentoring.model.Basket;
import com.example.springMentoring.model.ProductDTO;
import com.example.springMentoring.service.BasketService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<Basket> getAllBaskets() {
        return basketService.getAllBaskets();
    }

    @PostMapping(value = "/add",consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('write')")
    public void addProductToBasket(@RequestBody ProductDTO productDTO){
        return;
    }
}
