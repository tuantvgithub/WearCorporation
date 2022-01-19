package com.example.demo.client_ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
        ProductOrderDTO product1 = new ProductOrderDTO();
        product1.setProductId(1);
        product1.setProductImageUrl("/images/shop/products/product-1.jpg");
        product1.setProductPrice(100f);
        product1.setProductName("San pham 1");
        product1.setQuantity(2);

        ProductOrderDTO product2 = new ProductOrderDTO();
        product2.setProductId(2);
        product2.setProductImageUrl("/images/shop/products/product-2.jpg");
        product2.setProductPrice(200f);
        product2.setProductName("San pham 2");
        product2.setQuantity(1);
        List<ProductOrderDTO> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        //Calculate money
        Float subtotal=0f;
        for (ProductOrderDTO productOrderDTO : products) {
            subtotal+=(float)productOrderDTO.getProductPrice()*productOrderDTO.getQuantity();
        }

        checkoutDTO.setSubTotal(subtotal);
        checkoutDTO.setShipFee(0f);
        checkoutDTO.setVoucher(10f);
        checkoutDTO.setVoucherCode("SP02");

        float coef=(1-checkoutDTO.getVoucher()/100);
        checkoutDTO.setTotal(coef*(subtotal+checkoutDTO.getShipFee()));

        model.addAttribute("products", products);
        model.addAttribute("checkoutForm", checkoutDTO);
        return "checkout";
    }

    @PostMapping("/checkout")
    public ModelAndView placeOrder(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO, ModelMap model,
            RedirectAttributes rd) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login");



        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setCardNumber(checkoutDTO.getCardNumber());
        paymentInfo.setName(checkoutDTO.getCardHolder());
        paymentInfo.setCvv(checkoutDTO.getCvv());
        paymentInfo.setType("bank");
        paymentInfo.setExpired(checkoutDTO.getExpiredDate());
        paymentInfo.setMoney(checkoutDTO.getTotal());

        SP10PaymentResponseBean responseBean = paymentService.payment(paymentInfo);
        ModelAndView mv = new ModelAndView();
        String notice = null;
        switch (responseBean.getStatus()) {
            case 404:
                notice = responseBean.getMessage();
                mv.addObject("invalidCardNumber", notice);
                mv.addObject("checkoutForm", checkoutDTO);
                mv.setViewName("checkout");
                return mv;
            case 4061:
                notice = responseBean.getMessage();
                mv.addObject("invalidCvv", notice);
                mv.addObject("checkoutForm", checkoutDTO);
                mv.setViewName("checkout");
                return mv;
            case 4062:
                notice = responseBean.getMessage();
                mv.addObject("invalidName", notice);
                mv.addObject("checkoutForm", checkoutDTO);
                mv.setViewName("checkout");
                return mv;
            case 137:
                notice = responseBean.getMessage();
                mv.addObject("notEnough", notice);
                mv.addObject("checkoutForm", checkoutDTO);
                mv.setViewName("checkout");
                return mv;

        }
        rd.addFlashAttribute("checkoutForm", checkoutDTO);
        return new ModelAndView("redirect:/payment-confirmation");

    }
}
