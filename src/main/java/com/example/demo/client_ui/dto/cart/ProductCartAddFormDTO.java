package com.example.demo.client_ui.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartAddFormDTO {

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("size")
    private String size;

    @JsonProperty("color")
    private String color;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("name")
    private String name;

    @JsonProperty("userId")
    private Integer userId;
}
