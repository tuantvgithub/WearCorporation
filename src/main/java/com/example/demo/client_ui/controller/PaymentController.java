package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @GetMapping("/payment-confirmation")
    public String getPaymentConfirmationPage(Model model) {
        return "payment-confirmation";
    }

    @GetMapping("/payment-successful")
    public String getPaymentSuccessfulPage(Model model) {
        return "payment-successful";
    }
}
