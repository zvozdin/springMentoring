package com.example.springMentoring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PurchaseWithEmptyBasketException extends RuntimeException{

}
