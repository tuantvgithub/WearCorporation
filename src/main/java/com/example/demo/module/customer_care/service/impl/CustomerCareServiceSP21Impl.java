package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;
import com.example.demo.module.customer_care.proxies.CustomerCareSP21WebServiceProxy;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("sp21-customer-care")
public class CustomerCareServiceSP21Impl implements CustomerCareService {

    private final CustomerCareMapping customerCareMapping;
    private final CustomerCareSP21WebServiceProxy webServiceProxy;

    @Autowired
    private CustomerCareServiceSP21Impl(CustomerCareMapping customerCareMapping,
                                        CustomerCareSP21WebServiceProxy webServiceProxy) {
        this.customerCareMapping = customerCareMapping;
        this.webServiceProxy = webServiceProxy;
    }

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        List<SP21ProductCommentBean> commentBeanList = null;
        try {
            commentBeanList = this.webServiceProxy.getAllCommentByProductId(productId);
        } catch (Exception ignore) {
            return null;
        }

        if (commentBeanList == null || commentBeanList.isEmpty()) return null;
        List<ProductReviewDTO> reviewDTOList = new LinkedList<>();

        for (SP21ProductCommentBean commentBean : commentBeanList) {
            ProductReviewDTO reviewDTO = this.customerCareMapping.commentBeanToReviewDTO(commentBean);
            if (reviewDTO != null) reviewDTOList.add(reviewDTO);
        }

        return reviewDTOList;
    }
}
