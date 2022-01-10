package com.example.demo.module.product.service;

import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;

import java.util.List;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Long productId);
    List<ProductBriefDTO> getAllProductBriefDTO();

    List<CategoryDTO> getAllCategories();
}
