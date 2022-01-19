package com.example.demo.client_ui.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDTO {

    private int productId;

    private String productName;

    private String productImageUrl;

    private Float productPrice;

    private Integer quantity;
}
