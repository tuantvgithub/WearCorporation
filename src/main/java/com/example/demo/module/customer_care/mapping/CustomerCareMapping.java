package com.example.demo.module.customer_care.mapping;

import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;

public interface CustomerCareMapping {

    ProductReviewDTO commentBeanToReviewDTO(SP21ProductCommentBean commentBean);
}
