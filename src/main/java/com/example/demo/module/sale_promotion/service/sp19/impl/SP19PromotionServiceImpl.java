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

import lombok.extern.slf4j.Slf4j;

@Service("sp19-service")
@Slf4j
public class SP19PromotionServiceImpl implements PromotionService {

    @Autowired
    private SP19WebServiceProxy sp19WebServiceProxy;

    @Autowired
    private PromotionMapping promotionMapping;

    @Override
    public List<PromotionDTO> getAllSales() {

        try {
            List<PromotionSP19Bean> pros = sp19WebServiceProxy.getAllSales();

            return promotionMapping.beansToDtos(pros);

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new ArrayList<>();
        }
    }

    @Override
    public PromotionDetailDTO getPromotionById(String id) {

        try {
            
            PromoDetailSP19Bean promoDetailSP19Bean = sp19WebServiceProxy.getPromotionDetail(id);
            return promotionMapping.detailBeanToDto(promoDetailSP19Bean);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return PromotionDetailDTO.builder().build();
        }
    }

    @Override
    public List<VoucherCodeDTO> getAllVoucherCode() {

        try {

            List<CodeSP19Bean> codeBeans = sp19WebServiceProxy.getAllVoucherCode();
            List<VoucherCodeDTO> voucherCodeDTOs = new ArrayList<>();

            for (CodeSP19Bean code : codeBeans) {
                VoucherCodeDTO voucherCodeDTO = promotionMapping.codeBeanToDto(code);
                voucherCodeDTOs.add(voucherCodeDTO);
            }
            return voucherCodeDTOs;
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new ArrayList<>();
        }
    }

}
