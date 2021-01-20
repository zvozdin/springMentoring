package com.example.springMentoring.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, columnDefinition = "ACTIVE")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter(value = AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Basket> baskets = new ArrayList<>();

    public void addBasket(Basket basket) {
        baskets.add(basket);
        basket.setUser(this);
    }

    public void removeBasket(Basket basket) {
        baskets.remove(basket);
        basket.setUser(null);
    }
}
