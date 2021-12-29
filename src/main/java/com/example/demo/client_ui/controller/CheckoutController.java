package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model) {
        return "checkout";
    }
}
