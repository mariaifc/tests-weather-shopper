package com.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Card {
    VISA("4242424242424242", "1022", "123");

    private String cardNumber;
    private String expirationDate;
    private String cvc;
}
