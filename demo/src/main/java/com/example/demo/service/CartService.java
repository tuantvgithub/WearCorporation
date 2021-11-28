package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.proxies.CartWebServiceProxy;

import org.springframework.stereotype.Service;


public interface CartService {
   public CartDTO getCartInfo(int cartId); 
}
