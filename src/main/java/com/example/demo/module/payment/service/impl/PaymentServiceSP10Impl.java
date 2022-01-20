package com.example.demo.module.payment.service.impl;

import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.proxy.PaymentSP10WebServiceProxy;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp10-payment")
public class PaymentServiceSP10Impl implements PaymentService {

    @Autowired
    private PaymentSP10WebServiceProxy paymentSP10WebServiceProxy;
    
    @Override
    public SP10PaymentResponseBean payment(PaymentInfo paymentInfo) {
        
        return paymentSP10WebServiceProxy.payment(paymentInfo);
    }

    @Override
    public SP10PaymentResponseBean validate(PaymentInfo paymentInfo) {
       
        return paymentSP10WebServiceProxy.validate(paymentInfo);
    }
    
}
