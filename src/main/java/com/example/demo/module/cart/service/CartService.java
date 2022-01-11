package com.example.demo.module.cart.service;

import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;

public interface CartService {

    CartDTO getCartByAccountId(String id);

    CartDTO addProduct(String cartId, ProductCartAddFormDTO addFormDTO);

    CartDTO removeProduct(String cartId, Long productId);
}
