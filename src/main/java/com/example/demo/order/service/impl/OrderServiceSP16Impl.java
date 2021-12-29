package com.example.demo.order.service.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp16-order")
public class OrderServiceSP16Impl implements OrderService {

    @Override
    public List<OrderBriefDTO> getAllOrderDTOByUserId(Long userId) {
        return null;
    }

    @Override
    public OrderDetailDTO getOrderDTOById(Long orderId) {
        return null;
    }
}
