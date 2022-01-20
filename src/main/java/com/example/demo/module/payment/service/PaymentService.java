package com.example.demo.module.payment.service;

import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;

public interface PaymentService {

    SP10PaymentResponseBean payment(PaymentInfo paymentInfo);

    SP10PaymentResponseBean validate(PaymentInfo paymentInfo);

}
