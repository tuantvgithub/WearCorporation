package com.example.demo.client_ui.controller;

import java.util.List;

import com.example.demo.client_ui.dto.sale_promotion.PromotionDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDetailDTO;
import com.example.demo.module.sale_promotion.service.sp19.PromotionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/promotion")
public class SalePromotionController {
    
    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public ModelAndView getAllPromotions()
    {
        ModelAndView mv=new ModelAndView();
        List<PromotionDTO> promotionDTOs=promotionService.getAllSales();

        
        mv.addObject("promotions", promotionDTOs);
        mv.setViewName("promotion");

        return mv;
    }
    @GetMapping("/{id}")
    public ModelAndView getAllPromotions(@PathVariable("id") String id)
    {
        ModelAndView mv=new ModelAndView();
        PromotionDetailDTO promotionDetailDTO =promotionService.getPromotionById(id);

        mv.addObject("promotion", promotionDetailDTO);
        mv.setViewName("promotion-detail");

        return mv;
    }
}
