package com.example.demo.module.cart.service;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;

public interface CartService {

    CartDTO getCartByAccountId(UserDTO userDTO);

    void addProduct(ProductCartAddFormDTO addFormDTO);

    CartDTO removeProduct(String cartId, Integer productId);

    void createCart(UserDTO userDTO);

    void resetCart(UserDTO userDTO);

}
