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

    public void clearBaskets() {
        basketRepository.deleteAll();
    }

    @Transactional
    public void addOrChangeInToBasket(CreateBasketDTO basketDTO) {
        Basket basket = basketRepository.findByProductName(basketDTO.getName()).orElse(null);

        if (basket == null) {
            basket = createBasket(basketDTO);
        } else {
            basket.setQuantity(basketDTO.getQuantity());
            basket.setPrice(basketDTO.getQuantity() * basket.getProduct().getPrice());
        }

        basketRepository.save(basket);
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
}
