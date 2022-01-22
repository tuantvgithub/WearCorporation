package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.inventory.InventoryDetailProductDTO;
import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.inventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final String NOT_ENOUGH_PRODUCT_IN_WAREHOUSE = "Not enough product in warehouse! Maximum ";

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, CartService> cartServiceMap;

    @Autowired
    private Map<String, InventoryService> inventoryServiceMap;

    @Autowired
    public CartController(Map<String, CartService> cartServiceMap) {
        this.cartServiceMap = cartServiceMap;
    }

    @GetMapping
    public String getCartPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        CartService cartService = this.cartServiceMap.get(this.moduleConfig.getCartTeam());
        CartDTO cartDTO = cartService.getCartByAccountId(new UserDTO(this.currentAccount.getId()));

        if (cartDTO.getProductCartList() == null)
            cartDTO.setProductCartList(new ArrayList<>());

        model.addAttribute("cart", cartDTO);
        model.addAttribute("account", this.currentAccount);

        return "cart";
    }

    @PostMapping
    public String addProductToCart(ModelMap model,
            @ModelAttribute("productCartForm") ProductCartAddFormDTO addFormDTO) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";
        CartService cartService = this.cartServiceMap.get(this.moduleConfig.getCartTeam());
        InventoryService inventoryService = this.inventoryServiceMap.get(this.moduleConfig.getInventoryTeam());
        addFormDTO.setUserId(this.currentAccount.getId());

        // Check product available in warehouse
        InventoryDetailProductDTO inventoryProductDTO = inventoryService.getProductInInventoryById(addFormDTO.getId());
        if (inventoryProductDTO != null) {
            if (inventoryProductDTO.getTotal() > addFormDTO.getQuantity()) {

                cartService.addProduct(addFormDTO);
                return "redirect:/cart";
            }

        }

        model.addAttribute("notice", inventoryProductDTO!=null?NOT_ENOUGH_PRODUCT_IN_WAREHOUSE +inventoryProductDTO.getTotal():NOT_ENOUGH_PRODUCT_IN_WAREHOUSE);
        model.addAttribute("product", addFormDTO);
        return "product-detail";

    }
}
