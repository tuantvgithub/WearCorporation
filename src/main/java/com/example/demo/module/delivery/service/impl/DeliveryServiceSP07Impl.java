package com.example.demo.module.delivery.service.impl;

import com.example.demo.module.delivery.bean.sp07.SP07ResponseDeliveryBean;
import com.example.demo.module.delivery.proxies.DeliverySP07WebServiceProxy;
import com.example.demo.module.delivery.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("sp07-delivery")
@Slf4j
public class DeliveryServiceSP07Impl implements DeliveryService {

    @Autowired
    private DeliverySP07WebServiceProxy deliverySP07WebServiceProxy;
    
    @Override
    public SP07ResponseDeliveryBean calculateShipFee(String to_address) {
      try {
          
        return deliverySP07WebServiceProxy.calculateShipFee(to_address);
          
      } catch (Exception e) {
         log.error(e.getMessage(), e.getCause());
         return null;
      } 
    }
}
