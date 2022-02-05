package com.example.demo.module.customer_care.service;

import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackFormDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.client_ui.dto.product.ProductReviewFormDTO;

import java.util.List;

public interface CustomerCareService {

    List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId);
    ProductReviewDTO createProductReview(ProductReviewFormDTO formDTO);

    void sendFeedbackForm(FeedbackFormDTO formDTO);
    List<FeedbackDTO> getAllFeedback();
}
