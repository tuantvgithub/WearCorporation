package com.example.demo.module.cart.service.impl;

import java.util.List;
import java.util.Map;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.bean.CartResponse;
import com.example.demo.module.cart.bean.sp12.SP12ProductCartBean;
import com.example.demo.module.cart.mapping.CartMapping;
import com.example.demo.module.cart.proxies.CartSP12WebServiceProxy;
import com.example.demo.module.cart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp12-cart")
public class CartServiceSP12Impl implements CartService {

    @Autowired 
    private CartSP12WebServiceProxy cartSP12WebServiceProxy;

    @Autowired
    private CartMapping cartMapping;

    @Override
    public CartDTO getCartByAccountId(UserDTO userDTO) {

       List<SP12ProductCartBean> products=cartSP12WebServiceProxy.getCartInfo(userDTO).getData();
        if (userDTO != null) {

            return new CartDTO(cartMapping.mapListSP12BeanToListDTO(products));
        }
        return null;
    }

    @Override
    public void addProduct(ProductCartAddFormDTO addFormDTO) {

        cartSP12WebServiceProxy.addProductToCart(addFormDTO);
    }

    @Override
    public CartDTO removeProduct(String cartId, Integer productId) {
        return null;
    }

    @Override
    public void createCart(UserDTO userDTO) {
       
       cartSP12WebServiceProxy.createCart(userDTO);
    }

    @Override
    public void resetCart(UserDTO userDTO) {
        cartSP12WebServiceProxy.resetCart(userDTO);     
    }
}
