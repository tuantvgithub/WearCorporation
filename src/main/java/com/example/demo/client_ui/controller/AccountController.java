package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.ModuleConfig;
import com.example.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private Map<String, OrderService> orderServiceMap;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserDTO userDTO) {
        System.out.println(userDTO.getUsername());
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String getSignInPage(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") UserDTO userDTO) {
        return "redirect:/account/login";
    }

    @GetMapping("/address")
    public String getAddressPage(Model model) {
        return "address";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        return "profile";
    }

    @GetMapping("/orders")
    public String getOrderPage(Model model) {
        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        List<OrderBriefDTO> orderBriefDTOList = orderService.getAllOrderDTOByUserId(2L);
        if (orderBriefDTOList != null)
            model.addAttribute("orderList", orderBriefDTOList);

        return "order";
    }

    @GetMapping("/orders/{id}")
    public String getOrderDetailPage(@PathVariable Long id, Model model) {
        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        OrderDetailDTO orderDetailDTO = orderService.getOrderDTOById(id);
        if (orderDetailDTO != null)
            model.addAttribute("order", orderDetailDTO);

        return "order-detail";
    }

}
