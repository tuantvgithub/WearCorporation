package com.example.demo.client_ui.dto.product;

import lombok.Data;

@Data
public class ProductReviewFormDTO {

    private Integer userId;

    private Integer productId;

    private String content;
}
