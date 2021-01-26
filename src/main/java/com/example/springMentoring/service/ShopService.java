package com.example.springMentoring.service;

import com.example.springMentoring.exception.PurchaseWithEmptyBasketException;
import com.example.springMentoring.model.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
public class ShopService {

    private final UserService userService;
    private final ProductService productService;
    private final BasketService basketService;
    private final PurchaseService purchaseService;

    @Transactional
    public Purchase doPurchase() {
        Purchase purchase = purchaseService.addToPurchases(getPurchase());
        basketService.clearBaskets();
        return purchase;
    }

    @Transactional
    public Basket addOrChangeInToBasket(CreateBasketDTO basketDTO) {
        Basket basket = basketService.getBasketByProductName(basketDTO.getName())
                .map(value -> setNewPropertiesToBasket(value, basketDTO))
                .orElseGet(() -> createBasket(basketDTO));

        return basketService.addToBasket(basket);
    }

    private Basket setNewPropertiesToBasket(Basket basket, CreateBasketDTO basketDTO) {
        basket.setQuantity(basketDTO.getQuantity());
        basket.setPrice(basketDTO.getQuantity() * basket.getProduct().getPrice());
        return basket;
    }

    private Basket createBasket(CreateBasketDTO basketDTO) {
        Basket basket = new Basket();

        Product product = productService.getProductByName(basketDTO.getName());
        basket.setProduct(product);
        basket.setPrice(product.getPrice() * basketDTO.getQuantity());
        basket.setQuantity(basketDTO.getQuantity());

        User user = userService.getUserByLogin(basketDTO.getLogin());
        basket.setUser(user);
        user.addBasket(basket);

        return basket;
    }

    private Purchase getPurchase() {
        List<Basket> baskets = basketService.getAllBaskets();

        if (baskets.isEmpty()) {
            throw new PurchaseWithEmptyBasketException();
        }

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
