package com.example.demo.module.order.service.impl;

import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.module.order.bean.OrderRequestBean;
import com.example.demo.module.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp16-order")
public class OrderServiceSP16Impl implements OrderService {

    @Override
    public List<OrderBriefDTO> getAllOrderDTOByUserId(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderDetailDTO getOrderDTOById(Integer orderId) {
        // TODO Auto-generated method stub
        return null;
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
