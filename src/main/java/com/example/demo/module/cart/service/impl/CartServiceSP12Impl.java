package com.example.demo.module.cart.service.impl;

import java.util.Map;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;

import com.example.demo.module.cart.proxies.CartSP12WebServiceProxy;
import com.example.demo.module.cart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp12-cart")
public class CartServiceSP12Impl implements CartService {

    @Autowired 
    private CartSP12WebServiceProxy cartSP12WebServiceProxy;

    @Override
    public CartDTO getCartByAccountId(UserDTO userDTO) {

        if (userDTO != null) {

            return new CartDTO(cartSP12WebServiceProxy.getCartInfo(userDTO).getData());
        }
        return null;
    }

    @Override
    public CartDTO addProduct(String cartId, ProductCartAddFormDTO addFormDTO) {
        return null;
    }

    @Override
    public CartDTO removeProduct(String cartId, Integer productId) {
        return null;
    }

    @Override
    public CartDTO createCart(UserDTO userDTO) {
       
        return new CartDTO(cartSP12WebServiceProxy.createCart(userDTO).getData());
    }
}
