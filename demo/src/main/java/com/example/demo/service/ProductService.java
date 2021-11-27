package com.example.demo.service;

import com.example.demo.dto.ProductDetailDTO;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Long productId);

}
