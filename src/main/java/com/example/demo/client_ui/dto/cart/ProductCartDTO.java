package com.example.demo.client_ui.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDTO {

    
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("cartId")
    private Integer cartId;

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private Integer itemPrice;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("image_url")
    private String productImage;

    @JsonProperty("size")
    private String size;

    @JsonProperty("color")
    private String color;

}
