package com.example.springMentoring.rest;

import com.example.springMentoring.model.BasketDTO;
import com.example.springMentoring.model.BasketMapper;
import com.example.springMentoring.model.CreateBasketDTO;
import com.example.springMentoring.service.BasketService;
import com.example.springMentoring.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final ShopService shopService;
    private final BasketService basketService;
    private final BasketMapper basketMapper;

    // todo work out with security

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<BasketDTO> getAllBaskets() {
        return basketMapper.toBasketDTOs(basketService.getAllBaskets());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('write')")
    public BasketDTO addProductToBasket(@RequestBody CreateBasketDTO basketDTO){
        return basketMapper.toBasketDTO(shopService.addOrChangeInToBasket(basketDTO));
    }
}
