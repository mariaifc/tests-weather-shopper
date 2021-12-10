package com.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    //TODO Improve price to be Bigdecimal in task FLINK-123
    private String name;
    private int price;
}
