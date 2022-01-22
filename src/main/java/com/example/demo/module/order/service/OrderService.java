package com.example.demo.module.order.service;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;

import java.util.List;

public interface OrderService {

    List<OrderBriefDTO> getAllOrderDTOByUserId(Integer userId);
    OrderDetailDTO getOrderDTOById(Integer orderId);
    void updateOrder(Integer orderId,OrderDetailDTO updateOder);
    OrderDetailDTO createOrder(OrderDetailDTO orderDetailDTO);
}
