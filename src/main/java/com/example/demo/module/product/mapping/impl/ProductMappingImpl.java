package com.example.demo.module.product.mapping.impl;

import com.example.demo.module.product.bean.sp11.SP11CategoryBriefBean;
import com.example.demo.module.product.bean.sp11.SP11ProductBriefBean;
import com.example.demo.module.product.bean.sp11.SP11ProductDetailBean;
import com.example.demo.module.product.bean.sp17.SP17CategoryDetailBean;
import com.example.demo.module.product.bean.sp17.SP17ProductDetailBean;
import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.module.product.mapping.ProductMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductMappingImpl implements ProductMapping {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ProductBriefDTO detailDTOToBriefDTO(ProductDetailDTO detailDTO) {
        if (detailDTO == null) return null;
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setId(detailDTO.getId());
        briefDTO.setName(detailDTO.getName());
        briefDTO.setPrice(detailDTO.getPrice());
        briefDTO.setImageUrl(detailDTO.getImageUrl());

        return briefDTO;
    }

    @Override
    public ProductBriefDTO briefBeanToBriefDTO(HashMap<String, Object> briefData) {
        if (briefData == null) return null;

        SP11ProductBriefBean briefBean = this.objectMapper.convertValue(briefData, SP11ProductBriefBean.class);
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setImageUrl(briefBean.getMainImageUrl());
        briefDTO.setPrice(briefBean.getPrice());
        briefDTO.setId(briefBean.getId());
        briefDTO.setName(briefBean.getName());

        return briefDTO;
    }

    @Override
    public List<ProductBriefDTO> briefBeansToBriefDTOs(List<HashMap<String, Object>> briefDataList) {
        if (briefDataList == null) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();

        briefDataList.forEach(briefData -> briefDTOList.add(this.briefBeanToBriefDTO(briefData)));

        return briefDTOList;
    }

    @Override
    public ProductDetailDTO detailBeanToDetailDTO(HashMap<String, Object> detailData) {
        if (detailData == null) return null;

        SP11ProductDetailBean detailBean = this.objectMapper.convertValue(detailData, SP11ProductDetailBean.class);
        if (detailBean == null) return null;
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setBrand(detailBean.getBrand());
        detailDTO.setId(detailBean.getId());
        detailDTO.setPrice(detailBean.getPrice());
        detailDTO.setName(detailBean.getName());
        detailDTO.setImageUrl(detailBean.getMainImageUrl());
        detailDTO.setDescription(detailBean.getDetail());

        return detailDTO;
    }

    @Override
    public ProductDetailDTO detailBeanToDetailDTO(SP17ProductDetailBean detailBean) {
        if (detailBean == null) return null;
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setId(detailBean.getId());
        detailDTO.setPrice(detailBean.getPrice());
        detailDTO.setName(detailBean.getName());
        detailDTO.setDescription(detailBean.getDescription());
        detailDTO.setImageUrl(detailBean.getImage());

        return detailDTO;
    }

    @Override
    public CategoryDTO categoryBriefBeanToCategoryBriefDTO(HashMap<String, Object> briefData) {
        if (briefData == null) return null;

        SP11CategoryBriefBean categoryBriefBean =
                this.objectMapper.convertValue(briefData, SP11CategoryBriefBean.class);
        CategoryDTO categoryBriefDTO = new CategoryDTO();

        categoryBriefDTO.setId(categoryBriefBean.getId());
        categoryBriefDTO.setName(categoryBriefBean.getName());
        categoryBriefDTO.setDescription(categoryBriefBean.getDescription());
        categoryBriefDTO.setTax(categoryBriefBean.getTax());
        categoryBriefDTO.setUnit(categoryBriefBean.getUnit());

        return categoryBriefDTO;
    }

    @Override
    public CategoryDTO categoryDetailBeanToCategoryDTO(SP17CategoryDetailBean detailBean) {
        if (detailBean == null) return null;
        CategoryDTO dto = new CategoryDTO();

        dto.setId(detailBean.getId());
        dto.setName(detailBean.getName());

        return dto;
    }

    @Override
    public List<CategoryDTO> categoryBriefBeansToCategoryBriefDTO(
            List<HashMap<String, Object>> briefDataList) {
        if (briefDataList == null) return null;
        List<CategoryDTO> categoryBriefDTOList = new LinkedList<>();

        briefDataList.forEach(briefData -> categoryBriefDTOList.add(
                this.categoryBriefBeanToCategoryBriefDTO(briefData)));

        return categoryBriefDTOList;
    }

    @Override
    public ProductBriefDTO detailBeanToBriefDTO(SP17ProductDetailBean bean) {
        if (bean == null) return null;
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setId(bean.getId());
        briefDTO.setName(bean.getName());
        briefDTO.setPrice(bean.getPrice());
        briefDTO.setImageUrl(bean.getImage());

        return briefDTO;
    }
}
