package com.example.demo.order.mapping.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.order.bean.sp01.SP01OrderBean;
import com.example.demo.order.mapping.OrderMapping;
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
}
