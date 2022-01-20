package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, CartService> cartServiceMap;

    @Autowired
    public CartController(Map<String, CartService> cartServiceMap) {
        this.cartServiceMap = cartServiceMap;
    }

    @GetMapping
    public String getCartPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        CartService cartService = this.cartServiceMap.get(this.moduleConfig.getCartTeam());
        CartDTO cartDTO = cartService.getCartByAccountId(new UserDTO(1));

        if (cartDTO.getProductCartList() == null) cartDTO.setProductCartList(new ArrayList<>());

        model.addAttribute("cart", cartDTO);
        model.addAttribute("account", this.currentAccount);

        return "cart";
    }

    @PostMapping
    public String addProductToCart(Model model,
                                   @ModelAttribute("productCartForm") ProductCartAddFormDTO addFormDTO) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";
        CartService cartService = this.cartServiceMap.get(this.moduleConfig.getCartTeam());
        CartDTO cartDTO = cartService.getCartByAccountId(new UserDTO(this.currentAccount.getId()));
        CartDTO updatedCart = null;

        // if (cartDTO != null)
        //     updatedCart = cartService.addProduct(cartDTO.getId(), addFormDTO);
        // if (updatedCart != null)
        //     model.addAttribute("cart", updatedCart);

        // model.addAttribute("account", this.currentAccount);

        return "redirect:/cart";
    }
}
