package com.example.demo.module.cart.proxies;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.bean.CartResponse;
import com.example.demo.module.cart.bean.sp12.SP12CartBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sp12-api", url = "https://ltct-sp12-module-cart.herokuapp.com/api")
public interface CartSP12WebServiceProxy {

    @PostMapping("/cart")
    CartResponse<ProductCartDTO> getCartInfo(@RequestBody UserDTO userDTO);

    @PostMapping("/cartUser")
    CartResponse<ProductCartDTO> createCart(@RequestBody UserDTO userDTO);

     @PostMapping("/cartUser")
    CartResponse<ProductCartDTO> addProductToCart(@RequestBody ProductCartDTO productCartDTO);

}
