package com.example.demo.service.impl;

import com.example.demo.bean.CartBean;
import com.example.demo.dto.CartDTO;
import com.example.demo.mapping.CartMapping;
import com.example.demo.proxies.CartWebServiceProxy;
import com.example.demo.service.CartService;

public class CartServiceImpl implements CartService{

    private final CartWebServiceProxy  cartWebServiceProxy;
    private final CartMapping cartMapping;
    public CartServiceImpl(CartWebServiceProxy cartWebServiceProxy,CartMapping cartMapping)
    {
        this.cartWebServiceProxy=cartWebServiceProxy;
        this.cartMapping=cartMapping;
    } 
    @Override
    public CartDTO getCartInfo(int cartId) {
        CartBean cart=cartWebServiceProxy.getCartInfo(cartId);
        // TODO Auto-generated method stub
        return cartMapping.beanToCartDTO(cart);
    }
    
}
