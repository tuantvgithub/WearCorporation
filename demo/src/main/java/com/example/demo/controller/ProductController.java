package com.example.demo.controller;

import java.util.ArrayList;

import com.example.demo.dto.ProductBriefDTO;
import com.example.demo.service.ProductService;

import org.springframework.ui.Model;

public class ProductController {
    public ProductService productService;
    public String home(Model model)
    {
        ArrayList<ProductBriefDTO> pdto=productService.getListProductBriefDTO();
        model.addAttribute("productDTO", pdto);
        return "eshopper/shop";
    }
}
