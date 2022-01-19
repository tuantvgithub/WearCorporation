package com.example.demo.module.order.service.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.module.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("sp02-order")
public class OrderServiceSP02Impl implements OrderService {

    private final List<OrderBriefDTO> ORDER_BRIEF_DTO_LIST = Arrays.asList(
            new OrderBriefDTO(10L, "12/12/2021", 3,
                    500f, "Completed"),
            new OrderBriefDTO(11L, "13/12/2021", 2,
                    100f, "Canceled"),
            new OrderBriefDTO(12L, "30/12/2021", 2,
                    200f, "Processing"));

    private final List<ProductOrderDTO> PRODUCT_ORDER_DTO_LIST = Arrays.asList(
            new ProductOrderDTO(1, "Reef Boardsport",
                    "/images/shop/products/product-1.jpg", 100f, 3),
            new ProductOrderDTO(2, "Rainbow Shoes",
                    "/images/shop/products/product-2.jpg", 200f, 1),
            new ProductOrderDTO(3, "Stray horn SP",
                    "/images/shop/products/product-3.jpg", 100f, 2),
            new ProductOrderDTO(4, "Bradley Mid",
                    "/images/shop/products/product-4.jpg", 150f, 1)
    );

    @Override
    public List<OrderBriefDTO> getAllOrderDTOByUserId(Long userId) {
        if (userId == null) return null;
        return this.ORDER_BRIEF_DTO_LIST;
    }

    @Override
    public OrderDetailDTO getOrderDTOById(Long orderId) {
        OrderBriefDTO briefDTO = null;
        for (OrderBriefDTO dto : this.ORDER_BRIEF_DTO_LIST)
            if (orderId.equals(dto.getId())) briefDTO = dto;
        if (briefDTO == null) return null;

        OrderDetailDTO detailDTO = new OrderDetailDTO();
        detailDTO.setOrderId(briefDTO.getId());
        detailDTO.setStatus(briefDTO.getStatus());
        detailDTO.setOrderDate(briefDTO.getOrderDate());
        detailDTO.setTotalPrice(briefDTO.getTotalPrice());
        detailDTO.setProductList(this.PRODUCT_ORDER_DTO_LIST.subList(0,
                briefDTO.getNumberOfItems()));

        return detailDTO;
    }
}
