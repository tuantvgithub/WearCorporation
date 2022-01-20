package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.*;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.account.service.AccountService;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.order.service.OrderService;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private final Map<String, OrderService> orderServiceMap;

    @Autowired
    private  Map<String, CartService> cartServiceMap;

    @Autowired
    private final Map<String, AccountService> accountServiceMap;

    @Autowired
    private final Map<String, SystemManagementService> sysManagementServiceMap;

    public AccountController(Map<String, OrderService> orderServiceMap,
            Map<String, AccountService> accountServiceMap,
            Map<String, SystemManagementService> sysManagementServiceMap) {
        this.orderServiceMap = orderServiceMap;
        this.accountServiceMap = accountServiceMap;
        this.sysManagementServiceMap = sysManagementServiceMap;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelMap model) {
        if (this.currentAccount.getId() != null)
            return new ModelAndView("redirect:/", model);
        AccountLoginFormDTO loginFormDTO = new AccountLoginFormDTO();
        model.addAttribute("loginForm", loginFormDTO);

        return new ModelAndView("login", model);
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("loginForm") AccountLoginFormDTO formDTO,
            ModelMap model, HttpServletRequest request) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        SystemManagementService systemManagementService = this.sysManagementServiceMap
                .get(this.moduleConfig.getSysManagementTeam());

        AccountDTO accountDTO = accountService.login(formDTO);
        String notice = null;

        if (accountDTO == null)
            notice = "Failed";
        else {
            this.currentAccount.setId(accountDTO.getId());
            this.currentAccount.setEmail(accountDTO.getEmail());
            this.currentAccount.setFullname(accountDTO.getUsername());
            this.currentAccount.setPhone(accountDTO.getPhone());
            this.currentAccount.setRole(systemManagementService.getRoleByAccountId(accountDTO.getId().toString()));
            if (this.currentAccount.getRole() == AccountRoleDTO.ADMIN_ROLE)
                this.currentAccount.setAdmin(true);
        }
        model.addAttribute("notice", notice);
        model.addAttribute("account", this.currentAccount);

        return accountDTO == null ? new ModelAndView("login", model)
                : new ModelAndView("redirect:" + request.getHeader("referer"), model);
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelMap model) {
        this.currentAccount.setId(null);
        this.currentAccount.setEmail(null);
        this.currentAccount.setRole(AccountRoleDTO.GUEST_ROLE);

        model.addAttribute("notice", "Logout successfully");

        return new ModelAndView("login", model);
    }

    @GetMapping("/signup")
    public ModelAndView getSignInPage(ModelMap model) {
        AccountRegisterFormDTO registerFormDTO = new AccountRegisterFormDTO();
        model.addAttribute("registerForm", registerFormDTO);

        return new ModelAndView("signup", model);
    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute("registerForm") AccountRegisterFormDTO formDTO,
            ModelMap model) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        AccountDTO accountDTO = accountService.signup(formDTO);
        String notice = null;

        if (accountDTO == null)
            notice = "Failed";
        model.addAttribute("notice", notice);
        CartService cartService=cartServiceMap.get(this.moduleConfig.getCartTeam());
       cartService.createCart(new UserDTO(accountDTO.getId()));


        return accountDTO == null ? new ModelAndView("signup", model)
                : new ModelAndView("redirect:/account/login", model);
    }

    @GetMapping("/address")
    public ModelAndView getAddressPage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        return new ModelAndView("address", model);
    }

    @GetMapping("/profile")
    public ModelAndView getProfilePage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        System.out.println(this.currentAccount);
        ModelAndView mv = new ModelAndView();
        mv.addObject("profile", this.currentAccount);
        mv.setViewName("profile");

        return mv;
    }

    @GetMapping("/orders")
    public ModelAndView getOrderPage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        List<OrderBriefDTO> orderBriefDTOList = orderService.getAllOrderDTOByUserId(2L);
        if (orderBriefDTOList != null)
            model.addAttribute("orderList", orderBriefDTOList);

        return new ModelAndView("order", model);
    }

    @GetMapping("/orders/{id}")
    public ModelAndView getOrderDetailPage(@PathVariable Long id, ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        OrderDetailDTO orderDetailDTO = orderService.getOrderDTOById(id);
        if (orderDetailDTO != null)
            model.addAttribute("order", orderDetailDTO);

        return new ModelAndView("order-detail", model);
    }

}
