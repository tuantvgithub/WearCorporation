package com.example.demo.module.cart.bean.sp12;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP12CartBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("cartId")
    private Integer cartId;

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("image_url")
    private String imageUrl;


}
