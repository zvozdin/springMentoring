package com.example.springMentoring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateBasketDTO {

    private String login;
    private String name;
    private int quantity;
}
