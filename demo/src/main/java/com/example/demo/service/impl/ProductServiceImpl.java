package com.example.demo.service.impl;

import com.example.demo.bean.ProductBean;
import com.example.demo.dto.ProductDetailDTO;
import com.example.demo.mapping.ProductMapping;
import com.example.demo.proxies.ProductWebServiceProxy;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapping productMapping;
    private final ProductWebServiceProxy productWebServiceProxy;

    @Autowired
    public ProductServiceImpl(ProductMapping productMapping,
                              ProductWebServiceProxy productWebServiceProxy) {
        this.productMapping = productMapping;
        this.productWebServiceProxy = productWebServiceProxy;
    }

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        ProductBean productBean = this.productWebServiceProxy.findById(productId);

        return this.productMapping.beanToDetailDTO(productBean);
    }
}
