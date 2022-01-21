package com.example.demo.client_ui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import feign.Param;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CheckoutController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private CheckoutDTO checkout;

    @Autowired
    private Map<String, CartService> cartServiceMap;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/checkout")
    public String getCheckoutPage(@RequestParam(name = "method", required = false) String method,
            @ModelAttribute("voucher") String code,
            @ModelAttribute("type") String type, Model model) {

        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";
        CartService cartService = this.cartServiceMap.get(this.moduleConfig.getCartTeam());
        CartDTO cartDTO = cartService.getCartByAccountId(new UserDTO(this.currentAccount.getId()));

        List<ProductCartDTO> products = cartDTO.getProductCartList();

        CheckoutDTO checkoutDTO = new CheckoutDTO();
        checkoutDTO.setAddress("Bắc Từ Liêm");
        checkoutDTO.setCity("Hà Nội");
        checkoutDTO.setCardHolder("SPTwo SPFour");
        checkoutDTO.setCardNumber("123567");
        checkoutDTO.setCvv("4590");
        checkoutDTO.setExpiredDate("10/27");
        checkoutDTO.setVoucherCode(code);
        // Calculate money
        int subtotal = 0;
        for (ProductCartDTO productOrderDTO : products) {
            subtotal += productOrderDTO.getItemPrice() * productOrderDTO.getQuantity();
        }
        checkoutDTO.setSubTotal(subtotal);
        checkoutDTO.setTotal(subtotal);
        this.checkout=checkoutDTO;
       

        model.addAttribute("products", products);
        model.addAttribute("checkoutForm", checkoutDTO);

        if (!type.isEmpty()) {
            checkoutDTO.setPaymentMethod(type);
            return "checkout" + type;
        }
        if (method == null) {
            checkoutDTO.setPaymentMethod("bank");
            return "checkout";
        }
        checkoutDTO.setPaymentMethod(method);
        return "checkout"+method;
    }

    @PostMapping("/checkout")
    public ModelAndView placeOrder(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO, ModelMap model,
            RedirectAttributes rd) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login");

        String type = checkoutDTO.getPaymentMethod();
        System.out.println(checkoutDTO);
        if (!type.equals("cod")) {

            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setCardNumber(checkoutDTO.getCardNumber());
            paymentInfo.setName(checkoutDTO.getCardHolder());
            paymentInfo.setCvv(checkoutDTO.getCvv());
            paymentInfo.setType(checkoutDTO.getPaymentMethod());
            paymentInfo.setExpired(checkoutDTO.getExpiredDate());
            paymentInfo.setPhone(checkoutDTO.getPhone());
            paymentInfo.setPassword(checkoutDTO.getPassword());

            SP10PaymentResponseBean responseBean = paymentService.validate(paymentInfo);

            ModelAndView mv = new ModelAndView();
            String notice = null;
            switch (responseBean.getStatus()) {
                case 404:
                    notice = responseBean.getMessage();
                    mv.addObject("invalid", notice);
                    mv.addObject("checkoutForm", checkout);
                    mv.setViewName("checkout" + type);
                    return mv;
                case 406:
                    notice = responseBean.getMessage();
                    mv.addObject("invalidPassword", notice);
                    mv.addObject("checkoutForm", checkout);
                    mv.setViewName("checkout" + type);
                case 4061:
                    notice = responseBean.getMessage();
                    mv.addObject("invalidCvv", notice);
                    mv.addObject("checkoutForm", checkout);
                    mv.setViewName("checkout" + type);
                    return mv;
                case 4062:
                    notice = responseBean.getMessage();
                    mv.addObject("invalidName", notice);
                    mv.addObject("checkoutForm", checkout);
                    mv.setViewName("checkout" + type);
                    return mv;
            }
        }
        rd.addFlashAttribute("checkoutForm", checkout);
        return new ModelAndView("redirect:/payment-confirmation");

    }

    @GetMapping(value = "/voucher")
    public ModelAndView getVoucher(@RequestParam(name = "code") String code,
            @RequestParam(name = "type") String type, RedirectAttributes rd) {

        rd.addFlashAttribute("voucher", code);
        rd.addFlashAttribute("type", type);

        return new ModelAndView("redirect:/checkout");
    }

}
