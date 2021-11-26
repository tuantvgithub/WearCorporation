package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.ProductBean;
import com.example.demo.dto.ProductBriefDTO;
import com.example.demo.mapping.ProductMapping;
import com.example.demo.restapi.ProductRestAPI;

public class ProductService {
   public ProductRestAPI productAPI;
   public ProductMapping mapping;
   public ArrayList<ProductBriefDTO> getListProductBriefDTO()
   {
       List<ProductBean> products= productAPI.getListProducts();
       return mapping.productBeansToProductBriefDTOs(products);
       
   }
}
