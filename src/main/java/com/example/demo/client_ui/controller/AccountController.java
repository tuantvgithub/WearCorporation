package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.*;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.ModuleConfig;
import com.example.demo.module.account.service.AccountService;
import com.example.demo.module.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountDTO currentAccount;

    private AccountBriefDTO account;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private Map<String, OrderService> orderServiceMap;

    @Autowired
    private Map<String, AccountService> accountServiceMap;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        AccountLoginFormDTO loginFormDTO = new AccountLoginFormDTO();
        model.addAttribute("loginForm", loginFormDTO);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") AccountLoginFormDTO formDTO, Model model) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        this.currentAccount = accountService.login(formDTO);
        String error = null;

        if (this.currentAccount == null) error = "Failed";
        model.addAttribute("error", error);
        model.addAttribute("account", this.currentAccount);

        return this.currentAccount == null ? "login" : "redirect:/";
    }

    @GetMapping("/signup")
    public String getSignInPage(Model model) {
        AccountRegisterFormDTO registerFormDTO = new AccountRegisterFormDTO();
        model.addAttribute("registerForm", registerFormDTO);

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("registerForm") AccountRegisterFormDTO formDTO,
                         Model model) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        AccountDTO accountDTO = accountService.signup(formDTO);
        String error = null;

        if (accountDTO == null) error = "Failed";
        model.addAttribute("error", error);

        return accountDTO == null ? "signup" : "redirect:/account/login";
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
