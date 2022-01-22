package com.example.demo.module.customer_care.mapping.impl;

import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerCareMappingImpl implements CustomerCareMapping {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ProductReviewDTO commentBeanToReviewDTO(SP21ProductCommentBean commentBean) {
        if (commentBean == null) return null;
        ProductReviewDTO reviewDTO = new ProductReviewDTO();

        reviewDTO.setReviewId(commentBean.getId());
        reviewDTO.setContent(commentBean.getComment());
        reviewDTO.setDate(commentBean.getCreatedAt());
        reviewDTO.setUserId(commentBean.getUserId());

        return reviewDTO;
    }
}
