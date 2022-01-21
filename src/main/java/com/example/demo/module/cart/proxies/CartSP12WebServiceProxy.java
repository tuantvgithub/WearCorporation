package com.example.demo.module.cart.proxies;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.module.cart.bean.CartResponse;
import com.example.demo.module.cart.bean.sp12.SP12ProductCartBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sp12-api", url = "https://sp12-cart.herokuapp.com/api/")
public interface CartSP12WebServiceProxy {

    @PostMapping("/cart")
    CartResponse<SP12ProductCartBean> getCartInfo(@RequestBody UserDTO userDTO);

    @PostMapping("/cartUser")
    CartResponse<SP12ProductCartBean> createCart(@RequestBody UserDTO userDTO);

     @PostMapping("/cart/addProduct")
    CartResponse<SP12ProductCartBean> addProductToCart(@RequestBody ProductCartAddFormDTO productCartDTO);

     @PostMapping("/cart/removeAll")
    CartResponse<SP12ProductCartBean> resetCart(@RequestBody UserDTO userDTO);

    

    

}
