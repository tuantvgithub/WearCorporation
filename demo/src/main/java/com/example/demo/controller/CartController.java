package com.example.demo.controller;

import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartController {
   private final CartService cartService;
   @Autowired
   public CartController(CartService cartService) 
   {
      this.cartService=cartService;
   }
   @GetMapping
   public String getCartInfo()
   {
      return "cart";
   }
}
