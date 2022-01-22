package com.example.demo.module.product.proxies;

import com.example.demo.module.product.bean.sp17.SP17CategoryDetailBean;
import com.example.demo.module.product.bean.sp17.SP17ProductDetailBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sp17-api", url = "https://laptrinhcautrucapi.herokuapp.com")
public interface ProductSP17WebServiceProxy {

    @GetMapping("/product/show")
    List<SP17ProductDetailBean> getAllProduct();

    @GetMapping("/product/id")
    List<SP17ProductDetailBean> getProductById(@RequestParam("id") Integer productId);

    @GetMapping("/product/filters")
    List<SP17ProductDetailBean> getAllProduct(@RequestParam("category_id") Integer categoryId,
                                              @RequestParam(name = "size", required = false) String size,
                                              @RequestParam(name = "color", required = false) String color);

    @GetMapping("/category/show")
    List<SP17CategoryDetailBean> getAllCategories();

    @GetMapping("/category/id")
    List<SP17CategoryDetailBean> getCategoryById(@RequestParam Integer id);
}
