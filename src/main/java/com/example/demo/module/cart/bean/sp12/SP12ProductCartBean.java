package com.example.demo.module.cart.bean.sp12;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SP12ProductCartBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("userId")
    private Integer userId;

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

    @JsonProperty("color")
    private String color;

    @JsonProperty("size")
    private String size;


}
