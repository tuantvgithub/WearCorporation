package com.example.demo.proxies;

import com.example.demo.bean.ProductBean;

public interface ProductWebServiceProxy {

    ProductBean findById(Long productId);
}
