package com.example.springMentoring.rest;

import com.example.springMentoring.model.BasketDTO;
import com.example.springMentoring.model.BasketMapper;
import com.example.springMentoring.model.CreateBasketDTO;
import com.example.springMentoring.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final BasketService basketService;
    private final BasketMapper basketMapper;

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<BasketDTO> getAllBaskets() {
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOs(basketService.getAllBaskets());

        return basketDTOS;

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('write')")
    public void addProductToBasket(@RequestBody CreateBasketDTO basketDTO){
        basketService.addOrChangeInToBasket(basketDTO);
        return;
    }
}
