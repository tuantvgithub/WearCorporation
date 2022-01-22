package com.example.demo.module.product.service;

import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;

import java.util.HashMap;
import java.util.List;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Integer productId);
    List<ProductBriefDTO> getAllProductBriefDTO();
    List<ProductBriefDTO> getProductByFilter(HashMap<String, Object> params);

    List<CategoryDTO> getAllCategories();
}
