package com.example.demo.module.sale_promotion.proxies.sp19;

import java.util.List;

import com.example.demo.module.sale_promotion.bean.sp19.CodeSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromoDetailSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromotionSP19Bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "sp19-api",url = "https://ltct-sp19-api.herokuapp.com/api")
public interface SP19WebServiceProxy {
    
    @GetMapping("/sale/promotion")
    List<PromotionSP19Bean> getAllSales();

    @GetMapping("/sale/promotion/{id}")
    PromoDetailSP19Bean getPromotionDetail(@PathVariable("id") String id);

    @GetMapping("/sale/code")
    List<CodeSP19Bean> getAllVoucherCode();
}
