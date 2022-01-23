package com.example.demo.module.inventory.proxies;



import java.util.List;

import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;
import com.example.demo.module.inventory.bean.sp20.SP20ResponseDetailBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "sp20-api",url = "https://laptrinhcautruc-api.herokuapp.com")
public interface InventorySP20WebServiceProxy {
    
    @GetMapping("/product/getById/{id}")
    SP20ResponseDetailBean getProductInWarehouseById(@PathVariable("id") Integer id);
}
