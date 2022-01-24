package com.example.demo.module.order.service.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.module.order.bean.OrderRequestBean;
import com.example.demo.module.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("sp02-order")
public class OrderServiceSP02Impl implements OrderService {

    private final List<OrderBriefDTO> ORDER_BRIEF_DTO_LIST = Arrays.asList(
            new OrderBriefDTO(10, "12/12/2021", 3,
                    500, "Completed"),
            new OrderBriefDTO(11, "13/12/2021", 2,
                    100, "Canceled"),
            new OrderBriefDTO(12, "30/12/2021", 2,
                    200, "Processing"));

    private final List<ProductOrderDTO> PRODUCT_ORDER_DTO_LIST = Arrays.asList(
            new ProductOrderDTO(1, "Reef Boardsport",
                    "/images/shop/products/product-1.jpg", 100, 3,"red","X"),
            new ProductOrderDTO(2, "Rainbow Shoes",
                    "/images/shop/products/product-2.jpg", 200, 1,"red","X"),
            new ProductOrderDTO(3, "Stray horn SP",
                    "/images/shop/products/product-3.jpg", 100, 2,"red","X"),
            new ProductOrderDTO(4, "Bradley Mid",
                    "/images/shop/products/product-4.jpg", 150, 1,"red","X")
    );

    @Override
    public List<OrderBriefDTO> getAllOrderDTOByUserId(Integer userId) {
        if (userId == null) return null;
        return this.ORDER_BRIEF_DTO_LIST;
    }

    @Override
    public OrderDetailDTO getOrderDTOById(Integer orderId) {
        OrderBriefDTO briefDTO = null;
        for (OrderBriefDTO dto : this.ORDER_BRIEF_DTO_LIST)
            if (orderId.equals(dto.getId())) briefDTO = dto;
        if (briefDTO == null) return null;
        return OrderDetailDTO.builder()
                        .orderId(briefDTO.getId())
                        .status(briefDTO.getStatus())
                        .orderDate(briefDTO.getOrderDate())
                        .totalPrice(briefDTO.getTotalPrice())
                        .productList(this.PRODUCT_ORDER_DTO_LIST.subList(0, briefDTO.getNumberOfItems()))
                        .build();
    }

@Override
public void updateOrder(Integer orderId, OrderDetailDTO updateOder) {
        // TODO Auto-generated method stub
        
}

@Override
public OrderDetailDTO createOrder(OrderRequestBean orderDetailDTO) {
        // TODO Auto-generated method stub
        return null;
}
}
