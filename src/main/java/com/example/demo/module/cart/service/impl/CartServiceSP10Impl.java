package com.example.demo.module.cart.service.impl;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.module.cart.service.CartService;
import org.springframework.stereotype.Service;

@Service("sp10-cart")
public class CartServiceSP10Impl implements CartService {

    
   
    @Override
    public CartDTO removeProduct(String cartId,Integer productId) {
        return null;
    }

    @Override
    public CartDTO getCartByAccountId(UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createCart(UserDTO userDTO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resetCart(UserDTO userDTO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addProduct(ProductCartAddFormDTO addFormDTO) {
        // TODO Auto-generated method stub
        
    }

    
}
