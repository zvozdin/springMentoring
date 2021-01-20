package com.example.springMentoring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Long userId;
    private String name;
    private int quantity;
}
