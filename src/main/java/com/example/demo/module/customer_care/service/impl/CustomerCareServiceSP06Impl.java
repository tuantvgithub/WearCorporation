package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackFormDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.client_ui.dto.product.ProductReviewFormDTO;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp06-customer-care")
public class CustomerCareServiceSP06Impl implements CustomerCareService {

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        return null;
    }

    @Override
    public void sendFeedbackForm(FeedbackFormDTO formDTO) {

    }

    @Override
    public ProductReviewDTO createProductReview(ProductReviewFormDTO formDTO) {
        return null;
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() {
        return null;
    }
}
