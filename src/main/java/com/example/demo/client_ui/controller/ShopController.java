package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.client_ui.dto.product.ProductReviewFormDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.customer_care.service.CustomerCareService;
import com.example.demo.module.inventory.service.InventoryService;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, ProductService> productServiceMap;

    private final Map<String, CustomerCareService> customerCareServiceMap;

    private final Map<String, InventoryService> inventoryServiceMap;

    @Autowired
    private ShopController(Map<String, ProductService> productServiceMap,
                           Map<String, CustomerCareService> customerCareServiceMap,
                           Map<String, InventoryService> inventoryServiceMap) {
        this.productServiceMap = productServiceMap;
        this.customerCareServiceMap = customerCareServiceMap;
        this.inventoryServiceMap = inventoryServiceMap;
    }

    @GetMapping
    public String getShopPage(@RequestParam(name = "category_id", required = false) Integer categoryId,
                              Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        HashMap<String, Object> params = new HashMap<>();
        if (categoryId != null) params.put("category_id", categoryId);
        List<ProductBriefDTO> productBriefDTOList = productService.getProductByFilter(params);
        List<CategoryDTO> categoryDTOList = productService.getAllCategories();

        if (productBriefDTOList != null) {
            model.addAttribute("productList", productBriefDTOList);
            model.addAttribute("isLogin", currentAccount.getRole() != AccountRoleDTO.GUEST_ROLE ? true : false);
            model.addAttribute("userId", currentAccount.getId());
            model.addAttribute("teamNum", this.moduleConfig.getProductTeam().equals("sp17-product") ? 17 : 11);
        }
        if (categoryDTOList != null)
            model.addAttribute("categories", categoryDTOList);

        return "shop";
    }

    @GetMapping("/products/{id}")
    public String getProductDetailById(@PathVariable Integer id, Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        InventoryService inventoryService = this.inventoryServiceMap.get(this.moduleConfig.getInventoryTeam());

        ProductDetailDTO productDetailDTO = productService.getProductDetailDTOById(id);
        List<ProductBriefDTO> relatedProductList;

        if (productDetailDTO == null)
            return "redirect:/error";

        HashMap<String, Object> params = new HashMap<>();
        if (productDetailDTO.getCategoryDTO() != null) {
            params.put("category_id", productDetailDTO.getCategoryDTO().getId());
            relatedProductList = productService.getProductByFilter(params);
        } else {
            relatedProductList = productService.getAllProductBriefDTO();
        }

        List<ProductReviewDTO> productReviewDTOList = this.customerCareServiceMap.get(
                this.moduleConfig.getCustomerCareTeam()).getAllProductReviewByProductId(productDetailDTO.getId());

        model.addAttribute("product", productDetailDTO);
        model.addAttribute("quantity",
                inventoryService.getProductQuantityInInventory(productDetailDTO.getId(), null));
        model.addAttribute("notice", null);
        ProductCartAddFormDTO productCart= new ProductCartAddFormDTO();
        productCart.setImageUrl(productDetailDTO.getImageUrl());
        productCart.setId(productDetailDTO.getId());
        productCart.setPrice(productDetailDTO.getPrice());
        productCart.setName(productDetailDTO.getName());
        model.addAttribute("productCartForm", productCart);

        ProductReviewFormDTO reviewFormDTO = new ProductReviewFormDTO();
        reviewFormDTO.setUserId(this.currentAccount.getId());
        reviewFormDTO.setProductId(id);
        model.addAttribute("productReviewForm", reviewFormDTO);

        return "product-detail";
    }

    @PostMapping("/products/{id}/review")
    public RedirectView reviewProduct(@PathVariable("id") Integer productId,
                                      @ModelAttribute("productReviewForm") ProductReviewFormDTO reviewFormDTO,
                                      Model model) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/products/");

        // TODO

        return redirectView;
    }
}
