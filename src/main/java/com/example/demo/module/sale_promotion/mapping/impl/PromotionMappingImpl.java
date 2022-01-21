package com.example.demo.module.sale_promotion.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.sale_promotion.PromotionDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDetailDTO;
import com.example.demo.client_ui.dto.sale_promotion.VoucherCodeDTO;
import com.example.demo.module.sale_promotion.bean.sp19.CodeSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromoDetailSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromotionSP19Bean;
import com.example.demo.module.sale_promotion.mapping.PromotionMapping;

import org.springframework.stereotype.Component;

@Component
public class PromotionMappingImpl implements PromotionMapping {

    @Override
    public PromotionDTO beanToDto(PromotionSP19Bean bean) {

        PromotionDTO promotionDTO = PromotionDTO.builder()
                .id(bean.getId())
                .images(bean.getImages())
                .description(bean.getDescription())
                .name(bean.getName())
                .timeEnd(bean.getTimeEnd())
                .timeStart(bean.getTimeStart())
                .build();

        return promotionDTO;
    }

    @Override
    public List<PromotionDTO> beansToDtos(List<PromotionSP19Bean> beans) {

        List<PromotionDTO> promotionDTOs = new ArrayList<>();

        for (PromotionSP19Bean promotionSP19Bean : beans) {
            PromotionDTO promotionDTO = beanToDto(promotionSP19Bean);
            promotionDTOs.add(promotionDTO);
        }

        return promotionDTOs;
    }

    @Override
    public VoucherCodeDTO codeBeanToDto(CodeSP19Bean bean) {

        return VoucherCodeDTO.builder()
                .codeId(bean.getId())
                .count(bean.getCount())
                .description(bean.getDescription())
                .priceMin(bean.getPriceMin())
                .percentDiscount(bean.getPercentDiscount())
                .cashDiscount(bean.getCashDiscount())
                .name(bean.getName())
                .saleId(bean.getSaleId())
                .discountCode(bean.getDiscountCode())
                .build();
    }

    @Override
    public PromotionDetailDTO detailBeanToDto(PromoDetailSP19Bean bean) {

        PromotionDTO promotionDTO = beanToDto(bean.getSale());

        List<VoucherCodeDTO> codes = new ArrayList<>();

        for (CodeSP19Bean code : bean.getCodes()) {

            codes.add(codeBeanToDto(code));
        }

        return PromotionDetailDTO.builder()
                .codes(codes)
                .sale(promotionDTO)
                .build();
    }

}
