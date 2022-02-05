package com.example.demo.client_ui.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDTO {

    private Integer reviewId;

    private Integer userId;

    private Integer productId;

    private String userName;

    private String userImage;

    private String date;

    private String content;
}
