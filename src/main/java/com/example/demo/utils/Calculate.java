package com.example.demo.utils;

import java.util.Map;

import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.delivery.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;

public class Calculate {

   @Autowired
   private static ModuleConfig moduleConfig;

   @Autowired
   private static Map<String, DeliveryService> deliveryServiceMap;

   
   public static int calculateShippingFee(String address, String city) {
      DeliveryService deliveryService =deliveryServiceMap.get(moduleConfig.getDeliveryTeam());
      StringBuilder sb = new StringBuilder();
        sb.append(address);
        sb.append(" - ");
        sb.append(city);
        String to_address = sb.toString();
        System.out.println(to_address);
        int shipFee = deliveryService.calculateShipFee(to_address).getFee();
        System.out.println(shipFee);
        return shipFee;

   }
}
