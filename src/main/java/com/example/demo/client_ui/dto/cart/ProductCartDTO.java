package com.example.demo.client_ui.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartDTO {

    private Integer productId;

    private String productName;

    private String productImage;

    private Float itemPrice;

    private Integer quantity;

    private Float totalPrice;
}
