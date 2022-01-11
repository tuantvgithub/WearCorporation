package com.example.demo.client_ui.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartAddFormDTO {

    private Long productId;

    private Integer quantity;

    private String size;
}
