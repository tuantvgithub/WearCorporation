package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.customer_care.feedback.FeedbackFormDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.client_ui.dto.product.ProductReviewFormDTO;
import com.example.demo.module.customer_care.service.CustomerCareService;
import com.example.demo.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service("sp02-customer-care")
public class CustomerCareServiceSP02Impl implements CustomerCareService {

    public static Integer reviewCount = 1;
    private final List<ProductReviewDTO> PRODUCT_REVIEW_LIST = Arrays.asList(
            new ProductReviewDTO(1, 1, 1, "Jonathon Andrew",
                    "/images/blog/avater-1.jpg", "July 02, 2015, at 11:34",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +
                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
                            "atque ab a accusantium optio, dolor!"),
            new ProductReviewDTO(2, 4, 1, "Jonathon Andrew",
                    "/images/blog/avater-4.jpg", "July 02, 2015, at 11:34",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +
                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
                            "atque ab a accusantium optio, dolor!"),
            new ProductReviewDTO(3, 1, 1, "Jonathon Andrew",
                    "/images/blog/avater-1.jpg", "July 02, 2015, at 11:34",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque at " +
                            "magna ut ante eleifend eleifend. Lorem ipsum dolor sit amet, " +
                            "consectetur adipisicing elit. Magni natus, nostrum iste non delectus " +
                            "atque ab a accusantium optio, dolor!")
    );

    public static Integer feedbackCount = 1;
    private final List<FeedbackDTO> FEEDBACK_LIST = new LinkedList<>();

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        return PRODUCT_REVIEW_LIST;
    }

    @Override
    public ProductReviewDTO createProductReview(ProductReviewFormDTO formDTO) {
        if (formDTO == null) return null;
        ProductReviewDTO reviewDTO = new ProductReviewDTO();

        reviewDTO.setReviewId(reviewCount++);
        reviewDTO.setUserId(formDTO.getUserId());
        reviewDTO.setContent(formDTO.getContent());
        reviewDTO.setProductId(formDTO.getProductId());

        reviewDTO.setUserName("Shelby");
        reviewDTO.setDate(DateUtil.dateNow("dd/MM/yyyy"));
        reviewDTO.setUserImage("/images/blog/avater-1.jpg");

        PRODUCT_REVIEW_LIST.add(reviewDTO);

        return reviewDTO;
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() {
        return FEEDBACK_LIST;
    }

    @Override
    public void sendFeedbackForm(FeedbackFormDTO formDTO) {
        FeedbackDTO feedbackDTO = new FeedbackDTO();

        feedbackDTO.setFeedbackId(feedbackCount++);
        feedbackDTO.setUserId(formDTO.getUserId());
        feedbackDTO.setSubject(formDTO.getSubject());
        feedbackDTO.setMessage(formDTO.getMessage());

        FEEDBACK_LIST.add(feedbackDTO);
    }
}
