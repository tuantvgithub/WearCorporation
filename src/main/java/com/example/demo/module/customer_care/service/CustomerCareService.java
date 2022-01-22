package com.example.demo.module.customer_care.service;

import com.example.demo.client_ui.dto.product.ProductReviewDTO;

import java.util.List;

public interface CustomerCareService {

    List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId);
}
