package com.example.demo.client_ui.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDTO {

    @JsonProperty("product_id")
    private int productId;

    private String productName;

    private String productImageUrl;

    private Integer productPrice;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("color")
    private String color;

    @JsonProperty("size")
    private String size;
}
