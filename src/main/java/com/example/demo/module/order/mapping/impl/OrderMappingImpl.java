package com.example.demo.module.order.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.module.order.bean.sp01.SP01OrderBean;
import com.example.demo.module.order.mapping.OrderMapping;
import org.springframework.stereotype.Component;

@Component
public class OrderMappingImpl implements OrderMapping {

    @Override
    public OrderDetailDTO beanToDetailDTO(SP01OrderBean bean) {
        if (bean == null) return null;
        OrderDetailDTO detailDTO = new OrderDetailDTO();

        detailDTO.setOrderId(bean.getOrderId());
        detailDTO.setOrderDate(bean.getOrderTime());
        detailDTO.setTotalPrice(bean.getPrice());
        detailDTO.setStatus(bean.getStatus());

        return detailDTO;
    }

    @Override
    public OrderBriefDTO beanToBriefDTO(SP01OrderBean bean) {
        if (bean == null) return null;
        OrderBriefDTO briefDTO = new OrderBriefDTO();

        briefDTO.setId(bean.getOrderId());
        briefDTO.setOrderDate(bean.getOrderTime());
        if (bean.getProductOrderList() != null)
            briefDTO.setNumberOfItems(bean.getProductOrderList().size());
        briefDTO.setTotalPrice(bean.getPrice());
        briefDTO.setStatus(bean.getStatus());

        return briefDTO;
    }

    @Override
    public List<ProductOrderDTO> mapCartProductToOrderProduct(List<ProductCartDTO> cartDTOs) {
        
        List<ProductOrderDTO> orderProducts=new ArrayList<>();

        for (ProductCartDTO productCartDTO : cartDTOs) {
            
            ProductOrderDTO productOrderDTO=new ProductOrderDTO();

            productOrderDTO.setProductId(productCartDTO.getProductId());
            productOrderDTO.setProductName(productCartDTO.getProductName());
            productOrderDTO.setProductPrice(productCartDTO.getItemPrice());
            productOrderDTO.setQuantity(productCartDTO.getQuantity());
            productOrderDTO.setColor(productCartDTO.getColor());
            productOrderDTO.setSize(productCartDTO.getSize());

            orderProducts.add(productOrderDTO);
        }
        return orderProducts;
    }


}
