package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired 
    private PaymentService paymentService;

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        checkoutDTO.setTotal(300f);
        model.addAttribute("checkoutForm",checkoutDTO);
        return "checkout";
    }
    @PostMapping("/checkout")
    public String placeOrder(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

    //    PaymentInfo paymentInfo=new PaymentInfo();
    //    paymentInfo.setCardNumber(checkoutDTO.getCardNumber());
    //    paymentInfo.setName(checkoutDTO.getCardHolder());
    //    paymentInfo.setCvv(checkoutDTO.getCvv());
    //    paymentInfo.setType("type");
    //    paymentInfo.setBalance(checkoutDTO.getTotal());

       PaymentInfo paymentInfo=new PaymentInfo();
       paymentInfo.setCardNumber("123567");
       paymentInfo.setName("SPTwo SPFour");
       paymentInfo.setCvv("4590");
       paymentInfo.setType("bank");
       paymentInfo.setExpired("10/27");
       paymentInfo.setBalance(100000f);

       SP10PaymentResponseBean responseBean=paymentService.payment(paymentInfo);
       System.out.println(responseBean);
        
       return "checkout";
    }
}
