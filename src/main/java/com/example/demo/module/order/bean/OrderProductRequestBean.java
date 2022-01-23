package com.example.demo.module.order.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductRequestBean {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("color")
    private String color;

    @JsonProperty("size")
    private String size; 
}
