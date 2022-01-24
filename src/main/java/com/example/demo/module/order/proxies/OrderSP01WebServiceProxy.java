package com.example.demo.module.order.proxies;

import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.module.order.bean.OrderRequestBean;
import com.example.demo.module.order.bean.sp01.SP01OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sp01-order-api", url = "http://binhnguyen-tech.stackstaging.com/OrderModule/order")
public interface OrderSP01WebServiceProxy {

    @PostMapping("/{order_id}")
    List<SP01OrderBean> updateOrder(@RequestHeader("x-api-key") String token,
            @PathVariable(name = "order_id", required = true) Integer order_id,
            @RequestBody OrderDetailDTO updateOrder);

    @PostMapping
    SP01OrderBean createOrder(@RequestHeader("x-api-key") String token,
            @RequestBody OrderRequestBean orderDetailDTO);

    @GetMapping
    List<SP01OrderBean> getAllOrder(@RequestHeader("x-api-key") String token,
            @RequestParam(name = "limit", required = false) Integer limit);

    @GetMapping("/{id}")
    SP01OrderBean getOrderById(@RequestHeader("x-api-key") String token, @PathVariable Integer id);
}