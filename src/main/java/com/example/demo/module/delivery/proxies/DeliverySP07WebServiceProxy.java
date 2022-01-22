package com.example.demo.module.delivery.proxies;

import com.example.demo.module.delivery.bean.sp07.SP07ResponseDeliveryBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Param;

@FeignClient(value = "sp07-api",url = "https://ltct-sp-07.herokuapp.com/api/getShippingFee")
public interface DeliverySP07WebServiceProxy {

    @GetMapping
    SP07ResponseDeliveryBean calculateShipFee(@RequestParam(name="to_address") String to_address);
}
