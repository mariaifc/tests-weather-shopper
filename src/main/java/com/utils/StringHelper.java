package com.utils;

public class StringHelper {

    public static int getDigitsOnly(String string) {
        return Integer.valueOf(string.replaceAll("\\D+",""));
    }
}
