package com.example.demo.proxies.impl;

import com.example.demo.bean.ProductBean;
import com.example.demo.proxies.ProductWebServiceProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductWebServiceProxyImpl implements ProductWebServiceProxy {

    @Override
    public ProductBean findById(Long productId) {
        ProductBean bean = new ProductBean();

        bean.setId(1089772L);
        bean.setName("Anne Klein Sleeveless Color block Scuba");
        bean.setStars(4);
        bean.setBrand("E-SHOPPER");
        bean.setPrice(10);
        bean.setAvailability(true);
        bean.setImageUrl("/images/product-details/1.jpg");
        List<String> similarImageUrlList = Arrays.asList("/images/product-details/similar1.jpg",
                "/images/product-details/similar2.jpg", "/images/product-details/similar3.jpg",
                "/images/product-details/similar1.jpg", "/images/product-details/similar2.jpg",
                "/images/product-details/similar3.jpg", "/images/product-details/similar1.jpg",
                "/images/product-details/similar2.jpg", "/images/product-details/similar3.jpg");
        bean.setSimilarImageUrlList(similarImageUrlList);

        return bean;
    }
}
