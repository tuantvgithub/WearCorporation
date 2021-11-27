package com.example.demo.proxies;

import com.example.demo.bean.CartBean;

public interface CartWebServiceProxy {
    public CartBean getCartInfo(int cartId);
}
