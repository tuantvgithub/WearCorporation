package com.example.demo.module.cart.service.impl;

import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.service.CartService;
import org.springframework.stereotype.Service;

@Service("sp12-cart")
public class CartServiceSP12Impl implements CartService {

    @Override
    public CartDTO getCartByAccountId(String id) {
        return null;
    }

    @Override
    public CartDTO addProduct(String cartId, ProductCartAddFormDTO addFormDTO) {
        return null;
    }

    @Override
    public CartDTO removeProduct(String cartId, Long productId) {
        return null;
    }
}
