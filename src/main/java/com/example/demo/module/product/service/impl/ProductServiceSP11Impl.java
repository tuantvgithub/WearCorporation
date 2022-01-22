package com.example.demo.module.product.service.impl;

import com.example.demo.module.product.bean.sp11.SP11ResponseBean;
import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.module.product.mapping.ProductMapping;
import com.example.demo.module.product.proxies.ProductSP11WebServiceProxy;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("sp11-product")
public class ProductServiceSP11Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    private ProductSP11WebServiceProxy webServiceProxy;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Integer productId) {
        SP11ResponseBean<HashMap<String, Object>> responseBean =
                this.webServiceProxy.findById(productId);

        return responseBean.isSuccess() ?
                this.productMapping.detailBeanToDetailDTO(responseBean.getData()) : null;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        SP11ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.webServiceProxy.findAll();

        return responseBean.isSuccess() ?
                this.productMapping.briefBeansToBriefDTOs(responseBean.getData()) : null;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        SP11ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.webServiceProxy.getAllCategories();

        return responseBean.isSuccess() ?
                this.productMapping.categoryBriefBeansToCategoryBriefDTO(responseBean.getData()) : null;
    }

    @Override
    public List<ProductBriefDTO> getProductByFilter(HashMap<String, Object> params) {
        return this.getAllProductBriefDTO();
    }
}
