package com.example.demo.client_ui.controller;

import java.util.Date;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.account.CurrentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PaymentController {

    @Autowired
    private CurrentAccount currentAccount;

    @GetMapping("/payment-confirmation")
    public String getPaymentConfirmationPage(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO, ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        System.out.println(checkoutDTO);
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderDate(new Date().toString());
        orderDetailDTO.setTotalPrice(checkoutDTO.getTotal());
        orderDetailDTO.setPaymentMethod("Payment via bank card");
        orderDetailDTO.setStatus("Paid");
        orderDetailDTO.setSubTotal(0f);

        model.addAttribute("order", orderDetailDTO);
        return "payment-confirmation";
    }

    @GetMapping("/payment-successful")
    public String getPaymentSuccessfulPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        return "payment-successful";
    }
}
