package com.example.demo.mapping.impl;


import com.example.demo.bean.ProductBean;
import com.example.demo.dto.ProductBriefDTO;
import com.example.demo.dto.ProductDetailDTO;
import com.example.demo.mapping.ProductMapping;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductMappingImpl implements ProductMapping {

    @Override
    public ProductBriefDTO beanToBriefDTO(ProductBean bean) {
        if (bean == null) return null;
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setId(bean.getId());
        briefDTO.setName(bean.getName());
        briefDTO.setPrice(bean.getPrice());
        briefDTO.setImageUrl(bean.getImageUrl());

        return briefDTO;
    }

    @Override
    public List<ProductBriefDTO> beansToBriefDTOs(List<ProductBean> beans) {
        if (beans == null) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();

        for (ProductBean bean : beans)
            briefDTOList.add(this.beanToBriefDTO(bean));

        return briefDTOList;
    }

    @Override
    public ProductDetailDTO beanToDetailDTO(ProductBean bean) {
        if (bean == null) return null;
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setId(bean.getId());
        detailDTO.setAvailability(bean.isAvailability());
        detailDTO.setBrand(bean.getBrand());
        detailDTO.setPrice(bean.getPrice());
        detailDTO.setName(bean.getName());
        detailDTO.setStars(bean.getStars());
        detailDTO.setImageUrl(bean.getImageUrl());
        detailDTO.setSimilarImageUrlList(bean.getSimilarImageUrlList());

        return detailDTO;
    }

}
