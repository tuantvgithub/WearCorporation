package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.config.ModuleConfig;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, ProductService> productServiceMap;

    @Autowired
    public ShopController(Map<String, ProductService> productServiceMap) {
        this.productServiceMap = productServiceMap;
    }

    @GetMapping
    public String getShopPage(Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        List<ProductBriefDTO> productBriefDTOList = productService.getAllProductBriefDTO();

        if (productBriefDTOList != null)
            model.addAttribute("productList", productBriefDTOList);

        return "shop";
    }

    @GetMapping("/products/{id}")
    public String getProductDetailById(@PathVariable Long id, Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        ProductDetailDTO productDetailDTO = productService.getProductDetailDTOById(id);

        model.addAttribute("product", productDetailDTO);

        return "product-detail";
    }

}
