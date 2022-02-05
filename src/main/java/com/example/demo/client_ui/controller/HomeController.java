package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.module.advertisement.service.AdvertisementService;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

        @Autowired
        private CurrentAccount currentAccount;

        @Autowired
        private ModuleConfig moduleConfig;

        private final Map<String, AdvertisementService> advServiceMap;
        private final Map<String, ProductService> productServiceMap;
        private final Map<String, CartService> cartServiceMap;

        @Autowired
        public HomeController(Map<String, AdvertisementService> advServiceMap,
                        Map<String, ProductService> productServiceMap,
                        Map<String, CartService> cartServiceMap) {
                this.advServiceMap = advServiceMap;
                this.productServiceMap = productServiceMap;
                this.cartServiceMap = cartServiceMap;
        }
        
        @GetMapping("/")
        public String displayHomepage(Model model) {
                List<AdvertisementBriefDTO> advBriefList = this.advServiceMap.get(
                                this.moduleConfig.getAdvertisementTeam()).getAllAdvertisementBriefDTOs();
                List<ProductBriefDTO> trendyProductList = this.productServiceMap.get(
                                this.moduleConfig.getProductTeam()).getAllProductBriefDTO();
                CartDTO cartDTO=null;
                if (this.currentAccount.getId() != null) {

                        cartDTO = this.cartServiceMap.get(
                                        this.moduleConfig.getCartTeam())
                                        .getCartByAccountId(new UserDTO(this.currentAccount.getId()));
                }
                
                if (cartDTO != null && cartDTO.getProductCartList() != null)
                        model.addAttribute("productCartList",
                                        cartDTO.getProductCartList().size() > 1
                                                        ? cartDTO.getProductCartList().subList(0, 2)
                                                        : cartDTO.getProductCartList());
                if (advBriefList != null)
                        model.addAttribute("advList",
                                        advBriefList.size() > 2 ? advBriefList.subList(0, 3) : advBriefList);
                if (trendyProductList != null)
                        model.addAttribute("trendyProductList",
                                        trendyProductList.size() > 5 ? trendyProductList.subList(0, 6)
                                                        : trendyProductList);
                model.addAttribute("account", this.currentAccount);

                return "index";
        }
}
