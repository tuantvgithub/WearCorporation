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

import lombok.extern.slf4j.Slf4j;

@Service("sp12-cart")
@Slf4j
public class CartServiceSP12Impl implements CartService {

    @Autowired
    private CartSP12WebServiceProxy cartSP12WebServiceProxy;

    @Autowired
    private CartMapping cartMapping;

    @Override
    public CartDTO getCartByAccountId(UserDTO userDTO) {

        try {

            List<SP12ProductCartBean> products = cartSP12WebServiceProxy.getCartInfo(userDTO).getData();

            return new CartDTO(cartMapping.mapListSP12BeanToListDTO(products));

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return null;
        }
    }

    @Override
    public void addProduct(ProductCartAddFormDTO addFormDTO) {

        try {

            cartSP12WebServiceProxy.addProductToCart(addFormDTO);

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }

    @Override
    public CartDTO removeProduct(String cartId, Integer productId) {
        return null;
    }

    @Override
    public void createCart(UserDTO userDTO) {

        try {
            cartSP12WebServiceProxy.createCart(userDTO);

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void resetCart(UserDTO userDTO) {
        try {

            cartSP12WebServiceProxy.resetCart(userDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }
}
