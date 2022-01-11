package com.example.demo.module.cart.service.impl;

import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("sp02-cart")
public class CartServiceSP02Impl implements CartService {

    private final List<ProductCartDTO> productCartDTOList = new LinkedList<>(Arrays.asList(
            new ProductCartDTO(1L, "Reef Boardsport",
                    "/images/shop/products/product-1.jpg",
                    200., 2, 400.),
            new ProductCartDTO(2L, "Rainbow Shoes",
                    "/images/shop/products/product-2.jpg",
                    200., 1, 200.),
            new ProductCartDTO(3L, "Stray horn SP",
                    "/images/shop/products/product-3.jpg",
                    80., 3, 240.)));

    private final CartDTO cartDTO = new CartDTO("1", this.productCartDTOList, 840.);

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, ProductService> productServiceMap;

    @Autowired
    public CartServiceSP02Impl(Map<String, ProductService> productServiceMap) {
        this.productServiceMap = productServiceMap;
    }

    @Override
    public CartDTO getCartByAccountId(String id) {
        return id != null ? cartDTO : null;
    }

    @Override
    public CartDTO addProduct(String cartId, ProductCartAddFormDTO addFormDTO) {
        if (!cartId.equals(this.cartDTO.getId()) || addFormDTO.getQuantity() == null) return null;

        ProductDetailDTO detailDTO = this.productServiceMap.get(
                this.moduleConfig.getProductTeam()).getProductDetailDTOById(addFormDTO.getProductId());

        if (detailDTO == null) return this.cartDTO;

        this.cartDTO.getProductCartList().add(new ProductCartDTO(detailDTO.getId(),
                detailDTO.getName(), detailDTO.getImageUrl(), detailDTO.getPrice(),
                addFormDTO.getQuantity(), addFormDTO.getQuantity() * detailDTO.getPrice()));

        return this.cartDTO;
    }

    @Override
    public CartDTO removeProduct(String cartId, Long productId) {
        if (!cartId.equals(this.cartDTO.getId())) return null;
        for (ProductCartDTO productCartDTO : this.cartDTO.getProductCartList())
            if (productCartDTO.getProductId().equals(productId)) {
                Double tmp = productCartDTO.getTotalPrice();
                this.cartDTO.getProductCartList().remove(productCartDTO);
                this.cartDTO.setTotalPrice(this.cartDTO.getTotalPrice() - tmp);
            }

        return this.cartDTO;
    }
}
