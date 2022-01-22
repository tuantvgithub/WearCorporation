package com.example.demo.module.delivery.service;

import com.example.demo.module.delivery.bean.sp07.SP07ResponseDeliveryBean;

public interface DeliveryService {

    SP07ResponseDeliveryBean calculateShipFee(String to_address);
}
