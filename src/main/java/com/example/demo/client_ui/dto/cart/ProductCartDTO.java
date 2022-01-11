package com.example.demo.client_ui.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDTO {

    private Long productId;

    private String productName;

    private String productImage;

    private Double itemPrice;

    private Integer quantity;

    private Double totalPrice;
}
