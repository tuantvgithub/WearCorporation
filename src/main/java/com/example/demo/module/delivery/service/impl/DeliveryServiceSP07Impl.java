package com.example.demo.module.delivery.service.impl;

import com.example.demo.module.delivery.bean.sp07.SP07ResponseDeliveryBean;
import com.example.demo.module.delivery.proxies.DeliverySP07WebServiceProxy;
import com.example.demo.module.delivery.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp07-delivery")
public class DeliveryServiceSP07Impl implements DeliveryService {

    @Autowired
    private DeliverySP07WebServiceProxy deliverySP07WebServiceProxy;
    
    @Override
    public SP07ResponseDeliveryBean calculateShipFee(String to_address) {
       
        return deliverySP07WebServiceProxy.calculateShipFee(to_address);
    }
}
