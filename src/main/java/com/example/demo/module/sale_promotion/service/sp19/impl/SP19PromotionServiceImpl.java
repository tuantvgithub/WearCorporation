package com.example.demo.module.sale_promotion.service.sp19.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDetailDTO;
import com.example.demo.client_ui.dto.sale_promotion.VoucherCodeDTO;
import com.example.demo.module.sale_promotion.bean.sp19.CodeSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromoDetailSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromotionSP19Bean;
import com.example.demo.module.sale_promotion.mapping.PromotionMapping;
import com.example.demo.module.sale_promotion.proxies.sp19.SP19WebServiceProxy;
import com.example.demo.module.sale_promotion.service.sp19.PromotionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp19-service")
public class SP19PromotionServiceImpl implements PromotionService{

    @Autowired
    private SP19WebServiceProxy sp19WebServiceProxy;

    @Autowired
    private PromotionMapping promotionMapping;

    @Override
    public List<PromotionDTO> getAllSales() {

        List<PromotionSP19Bean> pros=sp19WebServiceProxy.getAllSales();
       
        return promotionMapping.beansToDtos(pros);
    }

    @Override
    public PromotionDetailDTO getPromotionById(String id) {
       
        PromoDetailSP19Bean promoDetailSP19Bean=sp19WebServiceProxy.getPromotionDetail(id);
        return promotionMapping.detailBeanToDto(promoDetailSP19Bean);
    }

    @Override
    public List<VoucherCodeDTO> getAllVoucherCode() {
        
        List<CodeSP19Bean> codeBeans=sp19WebServiceProxy.getAllVoucherCode();
        List<VoucherCodeDTO> voucherCodeDTOs=new ArrayList<>();

        for (CodeSP19Bean code : codeBeans) {
            VoucherCodeDTO voucherCodeDTO= promotionMapping.codeBeanToDto(code);
            voucherCodeDTOs.add(voucherCodeDTO);
        }
        return voucherCodeDTOs;
    }

    
    
    
}
