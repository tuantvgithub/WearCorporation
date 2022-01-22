package com.example.demo.module.cart.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.bean.sp12.SP12ProductCartBean;
import com.example.demo.module.cart.mapping.CartMapping;
import org.springframework.stereotype.Component;

@Component
public class CartMappingImpl implements CartMapping {

    @Override
    public ProductCartDTO mapSP12BeanToDto(SP12ProductCartBean sp12ProductCartBean) {
        
        ProductCartDTO productCartDTO=new ProductCartDTO();

        productCartDTO.setCartId(sp12ProductCartBean.getCartId());
        productCartDTO.setId(sp12ProductCartBean.getId());
        productCartDTO.setItemPrice(sp12ProductCartBean.getPrice());
        productCartDTO.setProductId(sp12ProductCartBean.getProductId());
        productCartDTO.setProductImage(sp12ProductCartBean.getImageUrl());
        productCartDTO.setProductName(sp12ProductCartBean.getName());
        productCartDTO.setSize(sp12ProductCartBean.getSize());
        productCartDTO.setColor(sp12ProductCartBean.getColor());
        productCartDTO.setQuantity(sp12ProductCartBean.getQuantity());
        return productCartDTO;
    }

    @Override
    public SP12ProductCartBean mapDtoToSp12Bean(ProductCartDTO productCartDTO) {
      SP12ProductCartBean sp12ProductCartBean=new SP12ProductCartBean();

        sp12ProductCartBean.setCartId(productCartDTO.getCartId());
        sp12ProductCartBean.setId(productCartDTO.getId());
        sp12ProductCartBean.setPrice(productCartDTO.getItemPrice());
        sp12ProductCartBean.setProductId(productCartDTO.getProductId());
        sp12ProductCartBean.setImageUrl(productCartDTO.getProductImage());
        sp12ProductCartBean.setName(productCartDTO.getProductName());
        sp12ProductCartBean.setSize(productCartDTO.getSize());
        sp12ProductCartBean.setColor(productCartDTO.getColor());
        sp12ProductCartBean.setQuantity(productCartDTO.getQuantity());
        return sp12ProductCartBean;
    }

    @Override
    public List<ProductCartDTO> mapListSP12BeanToListDTO(List<SP12ProductCartBean> listProduct) {
        
         List<ProductCartDTO> products=new ArrayList<>();
        for (SP12ProductCartBean sp12ProductCartBean : listProduct) {
            ProductCartDTO productCartDTO=mapSP12BeanToDto(sp12ProductCartBean);
            products.add(productCartDTO);
        }
        return products;
    }
}
