package com.example.demo.module.cart.service.impl;

import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("sp02-cart")
public class CartServiceSP02Impl implements CartService {

    private final List<ProductCartDTO> productCartDTOList = new LinkedList<>(Arrays.asList(
            // new ProductCartDTO(1,1, "Reef Boardsport",
            //         "/images/shop/products/product-1.jpg",
            //         200, 2),
            // new ProductCartDTO(2,2, "Rainbow Shoes",
            //         "/images/shop/products/product-2.jpg",
            //         200, 1),
            // new ProductCartDTO(3,3, "Stray horn SP",
            //         "/images/shop/products/product-3.jpg",
            //         80, 3)
            ));

    private final CartDTO cartDTO = new CartDTO(this.productCartDTOList);

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, ProductService> productServiceMap;

    @Autowired
    public CartServiceSP02Impl(Map<String, ProductService> productServiceMap) {
        this.productServiceMap = productServiceMap;
    }

    @Override
    public CartDTO getCartByAccountId(UserDTO userDTO) {
        return userDTO.getUserId()!= null ? cartDTO : null;
    }

    @Override
    public CartDTO removeProduct(String cartId, Integer productId) {
        // if (!cartId.equals(this.cartDTO.getId())) return null;
        // for (ProductCartDTO productCartDTO : this.cartDTO.getProductCartList())
        //     if (productCartDTO.getProductId().equals(productId)) {
        //         Integer tmp = productCartDTO.getTotalPrice();
        //         this.cartDTO.getProductCartList().remove(productCartDTO);
        //         this.cartDTO.setTotalPrice(this.cartDTO.getTotalPrice() - tmp);
        //     }

        return this.cartDTO;
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
