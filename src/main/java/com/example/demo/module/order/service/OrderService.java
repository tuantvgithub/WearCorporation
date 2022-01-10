package com.example.demo.module.order.service;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;

import java.util.List;

public interface OrderService {

    List<OrderBriefDTO> getAllOrderDTOByUserId(Long userId);
    OrderDetailDTO getOrderDTOById(Long orderId);
}
