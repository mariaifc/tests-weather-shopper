package com.utils;

import com.github.javafaker.Faker;

public class Randomizer {

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomZipCode() {
        return new Faker().address().zipCode();
    }
}
