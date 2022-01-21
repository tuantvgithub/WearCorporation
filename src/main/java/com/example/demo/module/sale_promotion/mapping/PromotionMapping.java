package com.example.demo.module.sale_promotion.mapping;

import java.util.List;

import com.example.demo.client_ui.dto.sale_promotion.PromotionDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDetailDTO;
import com.example.demo.client_ui.dto.sale_promotion.VoucherCodeDTO;
import com.example.demo.module.sale_promotion.bean.sp19.CodeSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromoDetailSP19Bean;
import com.example.demo.module.sale_promotion.bean.sp19.PromotionSP19Bean;

public interface PromotionMapping {
   
    PromotionDTO beanToDto(PromotionSP19Bean bean);

    List<PromotionDTO> beansToDtos(List<PromotionSP19Bean> beans);

    VoucherCodeDTO codeBeanToDto(CodeSP19Bean bean);

    PromotionDetailDTO detailBeanToDto(PromoDetailSP19Bean bean);
}
