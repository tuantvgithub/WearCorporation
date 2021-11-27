package com.example.demo.mapping;

import com.example.demo.bean.ProductBean;
import com.example.demo.dto.ProductBriefDTO;
import com.example.demo.dto.ProductDetailDTO;

import java.util.List;

public interface ProductMapping {

    ProductBriefDTO beanToBriefDTO(ProductBean bean);

    List<ProductBriefDTO> beansToBriefDTOs(List<ProductBean> beans);

    ProductDetailDTO beanToDetailDTO(ProductBean bean);

}
