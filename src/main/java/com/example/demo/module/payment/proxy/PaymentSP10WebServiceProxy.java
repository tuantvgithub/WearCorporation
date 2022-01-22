package com.example.demo.module.payment.proxy;

import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sp10-api", url = "https://stark-shore-97814.herokuapp.com/api/ver2/onlinePay")
public interface PaymentSP10WebServiceProxy {
    
    @PostMapping
    SP10PaymentResponseBean payment(@RequestBody PaymentInfo paymentInfo);

    @PostMapping
    SP10PaymentResponseBean validate(@RequestBody PaymentInfo paymentInfo);
    

}
