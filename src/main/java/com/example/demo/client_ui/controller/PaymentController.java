package com.example.demo.client_ui.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.delivery.bean.sp07.SP07ResponseDeliveryBean;
import com.example.demo.module.delivery.service.DeliveryService;
import com.example.demo.module.order.service.OrderService;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    private PaymentInfo paymentInfo;

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private Map<String, DeliveryService> deliveryServiceMap;

    @Autowired
    private Map<String, CartService> cartServiceMap;


    @Autowired
    private Map<String, OrderService> orderServiceMap;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment-confirmation")
    public String getPaymentConfirmationPage(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO, ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        OrderService orderService = orderServiceMap.get(this.moduleConfig.getOrderTeam());
        DeliveryService deliveryService = this.deliveryServiceMap.get(this.moduleConfig.getDeliveryTeam());
         CartService cartService =cartServiceMap.get(this.moduleConfig.getCartTeam());

         System.out.println(checkoutDTO);
        StringBuilder sb = new StringBuilder();
        sb.append(checkoutDTO.getAddress());
        sb.append(" - ");
        sb.append(checkoutDTO.getCity());
        String to_address = sb.toString();
        SP07ResponseDeliveryBean shipFee = deliveryService.calculateShipFee(to_address);

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setPaymentMethod(checkoutDTO.getPaymentMethod());
        orderDetailDTO.setAddress(to_address);
        orderDetailDTO.setSubTotal(checkoutDTO.getSubTotal());
        orderDetailDTO.setVoucherCode(checkoutDTO.getVoucherCode());
        orderDetailDTO.setUserId(this.currentAccount.getId());

       // List<ProductOrderDTO> products=cartService.getCartByAccountId(new UserDTO(this.currentAccount.getId())).getProductCartList();
        
        // Call api create order
       // orderService.createOrder(orderDetailDTO);
        
        orderDetailDTO.setOrderId(1L);
        orderDetailDTO.setShipFee(shipFee.getFee());
        orderDetailDTO.setStatus("Unpaid");
        orderDetailDTO.setVoucher(checkoutDTO.getVoucher());
        orderDetailDTO.setOrderDate(new Date().toString());
        orderDetailDTO.setTotalPrice(checkoutDTO.getSubTotal());

        // Save payment info
        if(!checkoutDTO.getPaymentMethod().equals("cod"))
        {

            PaymentInfo payment = new PaymentInfo();
            payment.setCardNumber(checkoutDTO.getCardNumber());
            payment.setName(checkoutDTO.getCardHolder());
            payment.setCvv(checkoutDTO.getCvv());
            payment.setType("bank");
            payment.setExpired(checkoutDTO.getExpiredDate());
            payment.setMoney(orderDetailDTO.getTotalPrice());
            this.paymentInfo = payment;
        }

        model.addAttribute("order", orderDetailDTO);

        return "payment-confirmation";
    }

    @PostMapping("/payment-confirmation")
    public String paymentConfirmation(@ModelAttribute("order") OrderDetailDTO orderDetailDTO, ModelMap model) {

        OrderService orderService = orderServiceMap.get(this.moduleConfig.getOrderTeam());
        CartService cartService =cartServiceMap.get(this.moduleConfig.getCartTeam());
        if(!orderDetailDTO.getPaymentMethod().equals("cod"))
        {
            SP10PaymentResponseBean responseBean = paymentService.payment(paymentInfo);
            String notice = null;
            if (responseBean.getStatus() == 137) {
                notice = responseBean.getMessage();
                model.addAttribute("notEnough", notice);
    
                return "payment-confirmation";
            }
        }

        //Update order Info
        // OrderDetailDTO updateOrder = new OrderDetailDTO();
        // updateOrder.setStatus("Paid");
        // orderService.updateOrder(orderDetailDTO.getOrderId(), updateOrder);

        cartService.resetCart(new UserDTO(this.currentAccount.getId()));


        return "redirect:/payment-successful";
    }

    @GetMapping("/payment-successful")
    public String getPaymentSuccessfulPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        return "payment-successful";
    }
}
