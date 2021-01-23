package com.example.springMentoring.service;

import com.example.springMentoring.dao.BasketRepository;
import com.example.springMentoring.model.Basket;
import com.example.springMentoring.model.CreateBasketDTO;
import com.example.springMentoring.model.Product;
import com.example.springMentoring.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final UserService userService;
    private final ProductService productService;

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    @Transactional
    public void addOrChangeInToBasket(CreateBasketDTO basketDTO) {
        Basket basket = basketRepository.findByProductName(basketDTO.getName()).orElse(null);

        if (basket == null) {
            Product product = productService.getProductByName(basketDTO.getName());
            User user = userService.getUserByLogin(basketDTO.getLogin());

            basket = getBasket(basketDTO, product, user);
        } else {
            basket.setQuantity(basketDTO.getQuantity());
            basket.setPrice(basketDTO.getQuantity() * basket.getProduct().getPrice());
        }

        basketRepository.save(basket);
    }

    private Basket getBasket(CreateBasketDTO basketDTO, Product product, User user) {
        Basket basket = new Basket();
        basket.setProduct(product);
        basket.setUser(user);
        basket.setQuantity(basketDTO.getQuantity());
        basket.setPrice(product.getPrice() * basketDTO.getQuantity());
        return basket;
    }
}
