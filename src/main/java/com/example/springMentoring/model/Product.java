package com.example.springMentoring.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @Setter(value = AccessLevel.PRIVATE)
    private List<Basket> baskets = new ArrayList<>();

    public void addBasket(Basket basket) {
        baskets.add(basket);
        basket.setProduct(this);
    }

    public void removeBasket(Basket basket) {
        baskets.remove(basket);
        basket.setProduct(null);
    }
}
