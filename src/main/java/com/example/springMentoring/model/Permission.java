package com.example.springMentoring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {

    READ("read"),
    WRITE("write");

    private final String permission;
}
